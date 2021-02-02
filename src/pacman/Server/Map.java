package pacman.Server;

import javafx.util.Pair;
import pacman.Server.enums.BoardObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private BoardObject[][] board;

    private Point playerStartingPoint;

    private List<Point> enemyStartingPoints;

    private int boardHeight;

    private int boardWidth;

    Map(BoardObject[][] board) {
        boardHeight = board.length;
        boardWidth = board[0].length;
        this.board = new BoardObject[boardHeight][boardWidth];
        enemyStartingPoints = new ArrayList<>();

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if (board[row].length != boardWidth) {
                    throw new IllegalStateException("Błędny wiesz");
                }
                BoardObject cellValue = board[row][col];
                if (cellValue == BoardObject.PACMAN_HOME) {
                    playerStartingPoint = new Point(row, col);
                    this.board[row][col] = BoardObject.EMPTY;
                } else if (cellValue == BoardObject.GHOST_HOME) {
                    enemyStartingPoints.add(new Point(row, col));
                    this.board[row][col] = BoardObject.EMPTY;
                } else {
                    this.board[row][col] = cellValue;
                }
            }
        }

        if (playerStartingPoint == null || enemyStartingPoints.isEmpty()) {
            throw new IllegalStateException("Brak punktów startowych");
        }
    }

    public BoardObject[][] getBoard() {
        return board;
    }

    public BoardObject getBoardObjectAtPoint(Point point) {
        return board[point.x][point.y];
    }

    public void clearBoardObjectAtPoint(Point point) {
        board[point.x][point.y] = BoardObject.EMPTY;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public Point getPlayerStartingPoint() {
        return playerStartingPoint;
    }

    public Point getRandomEnemyStartingPoints() {
        return enemyStartingPoints.get(new Random().nextInt(enemyStartingPoints.size()));
    }

    public boolean noMorePoints() {
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if(board[row][col] == BoardObject.POINT || board[row][col] == BoardObject.POWER_UP) {
                    return false;
                }
            }
        }
        return true;
    }
}
