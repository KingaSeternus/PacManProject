package pacman.Server.enums;

public enum MoveDirection {
    UP(0, -1),
    DOWN(0, 1),
    RIGHT(1, 0),
    LEFT(-1, 0);

    private int changeInX;
    private int changeInY;

    MoveDirection(int changeInX, int changeInY) {
        this.changeInX = changeInX;
        this.changeInY = changeInY;
    }

    public int getChangeInX() {
        return changeInX;
    }

    public int getChangeInY() {
        return changeInY;
    }
}