package pacman.Server;

import pacman.Server.enums.EnemyType;
import pacman.Server.enums.GameStatus;
import pacman.Server.enums.MoveDirection;
import pacman.Server.maps.map_1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static pacman.Server.Strategy.determineMoveStrategyForEnemy;

public class Game {

    private final static int RUNNING_TIME = 20;

    private GameStatus gameStatus;

    private Player player;

    private Map map;

    private List<Enemy> enemies = new ArrayList<>();

    private Boolean isRunningTime = Boolean.FALSE;

    private int runningTimeTimer;

    private int score;

    public Game() {
        this.map = new Map(map_1.getBoard());
        startNewGame();
        this.gameStatus = GameStatus.PAUSE;
    }

    public void startNewGame() {
        gameStatus = GameStatus.PLAY;
        score = 0;
        player = new Player(map.getPlayerStartingPoint());
        enemies.clear();
        enemies.add(new Enemy(EnemyType.RED, map.getRandomEnemyStartingPoints()));
        enemies.add(new Enemy(EnemyType.ORANGE, map.getRandomEnemyStartingPoints()));
    }

    public void iteration() {
        // Check winning condition
        if (map.noMorePoints()) {
            gameStatus = GameStatus.WIN;
        }

        // Player move
        if (gameStatus == GameStatus.PLAY) {
            playerMove();
            checkConflict();
        }

        // Enemy move
        if (gameStatus == GameStatus.PLAY) {
            for (Enemy enemy : enemies) {
                determineMoveStrategyForEnemy(enemy, map, player.getLocalization(), isRunningTime);
            }
            checkConflict();
        }

        // Timer
        if (isRunningTime) {
            runningTimeTimer--;
            if (runningTimeTimer < 0) {
                isRunningTime = Boolean.FALSE;
            }
        }
    }

    private void checkConflict() {
        for (Enemy enemy : enemies) {
            if (enemy.getLocalization().equals(player.getLocalization())) {
                if (isRunningTime) {
                    score += 200;
                    enemy.setLocalization(map.getRandomEnemyStartingPoints());
                } else {
                    gameStatus = GameStatus.LOSE;
                }
            }
        }
    }

    private void playerMove() {
        Point nextLocation = nextLocation(player.getLocalization(), player.getCurrentMoveDirection());
        switch (map.getBoardObjectAtPoint(nextLocation)) {
            case POWER_UP:
                isRunningTime = Boolean.TRUE;
                runningTimeTimer = RUNNING_TIME;
                score += 40;
            case POINT:
                map.clearBoardObjectAtPoint(nextLocation);
                score += 10;
            case EMPTY:
                player.setLocalization(nextLocation);
                break;
            case WALL:
                break;
        }
    }

    private Point nextLocation(Point currentLocation, MoveDirection moveDirection) {
        return new Point(currentLocation.x + moveDirection.getChangeInX(), currentLocation.y + moveDirection.getChangeInY());
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getRunningTimeTimer() {
        return runningTimeTimer;
    }

    public int getScore() {
        return score;
    }

    public String getGameInfo() {
        return gameStatus.getTranslation();
    }
}
