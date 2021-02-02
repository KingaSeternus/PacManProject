package pacman.UI;

import pacman.Server.Enemy;
import pacman.Server.Game;
import pacman.Server.enums.BoardObject;
import pacman.Server.enums.MoveDirection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Model {

    private BoardObject[][] board;

    private Point playerPosition;

    private MoveDirection playerDirection;

    private List<Enemy> enemies;

    private boolean showDead;

    private Model() {
        enemies = new ArrayList<>();
    }

    BoardObject[][] getBoard() {
        return board;
    }

    Point getPlayerPosition() {
        return playerPosition;
    }

    MoveDirection getPlayerDirection() {
        return playerDirection;
    }

    List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isShowDead() {
        return showDead;
    }

    static Model retrieveModel(Game game) {
        return new ModelBuilder()
                .withBoard(game.getMap().getBoard())
                .withPlayerPosition(game.getPlayer().getLocalization())
                .withPlayerDirection(game.getPlayer().getCurrentMoveDirection())
                .withEnemies(game.getEnemies())
                .withShowDead(game.getRunningTimeTimer())
                .build();
    }

    private static class ModelBuilder {

        Model buildedModel;

        ModelBuilder() {
            buildedModel = new Model();
        }

        ModelBuilder withBoard(BoardObject[][] board) {
            buildedModel.board = board;
            return this;
        }

        ModelBuilder withPlayerPosition(Point playerPosition) {
            buildedModel.playerPosition = playerPosition;
            return this;
        }

        ModelBuilder withPlayerDirection(MoveDirection playerDirection) {
            buildedModel.playerDirection = playerDirection;
            return this;
        }

        ModelBuilder withEnemies(List<Enemy> enemies) {
            buildedModel.enemies = enemies;
            return this;
        }

        ModelBuilder withShowDead(int runningTimeTimer) {
            buildedModel.showDead = runningTimeTimer > 8 || runningTimeTimer % 2 == 1;
            return this;
        }


        Model build() {
            return buildedModel;
        }
    }
}
