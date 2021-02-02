package pacman.UI;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pacman.Server.Enemy;
import pacman.Server.enums.BoardObject;
import pacman.Server.enums.MoveDirection;

import java.awt.*;
import java.util.List;

import static pacman.UI.ImageStatics.*;

public class View extends Group {

    private final static double CELL_SIZE = 30.0;

    private ImageView[][] imageGrid;

    public View() {
    }

    void initializeGrid(int rowNumber, int colNumber) {
        imageGrid = new ImageView[rowNumber][colNumber];
        for (int row = 0; row < rowNumber; row++) {
            for (int col = 0; col < colNumber; col++) {
                ImageView imageView = new ImageView();
                imageView.setX((double) row * CELL_SIZE);
                imageView.setY((double) col * CELL_SIZE);
                imageView.setFitWidth(CELL_SIZE);
                imageView.setFitHeight(CELL_SIZE);
                this.imageGrid[row][col] = imageView;
                this.getChildren().add(imageView);
            }
        }
    }

    void updateView(Model model) {
        updateBoard(model.getBoard());
        updatePlayer(model.getPlayerPosition(), model.getPlayerDirection());
        updateEnemy(model.getEnemies(), model.isShowDead());
    }

    private void updateBoard(BoardObject[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                switch (board[row][col]) {
                    case EMPTY:
                        imageGrid[row][col].setImage(null);
                        break;
                    case WALL:
                        imageGrid[row][col].setImage(WALL_IMAGE);
                        break;
                    case POINT:
                        imageGrid[row][col].setImage(POINT_IMAGE);
                        break;
                    case POWER_UP:
                        imageGrid[row][col].setImage(POWER_UP_IMAGE);
                        break;
                }
            }
        }
    }

    private void updatePlayer(Point playerPosition, MoveDirection playerDirection) {
        Image imageForPlayer = PACMAN_UP_IMAGE;
        switch (playerDirection) {
            case UP:
                imageForPlayer = PACMAN_UP_IMAGE;
                break;
            case DOWN:
                imageForPlayer = PACMAN_DOWN_IMAGE;
                break;
            case RIGHT:
                imageForPlayer = PACMAN_RIGHT_IMAGE;
                break;
            case LEFT:
                imageForPlayer = PACMAN_LEFT_IMAGE;
                break;
        }
        imageGrid[playerPosition.x][playerPosition.y].setImage(imageForPlayer);
    }

    private void updateEnemy(List<Enemy> enemies, boolean showDead) {
        for (Enemy enemy : enemies) {
            Image imageForEnemy = RED_GHOST_IMAGE;
            if (showDead) {
                imageForEnemy = DEAD_GHOST_IMAGE;
            } else {
                switch (enemy.getType()) {
                    case RED:
                        imageForEnemy = RED_GHOST_IMAGE;
                        break;
                    case ORANGE:
                        imageForEnemy = ORANGE_GHOST_IMAGE;
                        break;
                    case PINK:
                        imageForEnemy = PINK_GHOST_IMAGE;
                        break;
                    case TURQUOISE:
                        imageForEnemy = TURQUOISE_GHOST_IMAGE;
                        break;
                }
            }
            imageGrid[enemy.getLocalization().x][enemy.getLocalization().y].setImage(imageForEnemy);
        }
    }
}
