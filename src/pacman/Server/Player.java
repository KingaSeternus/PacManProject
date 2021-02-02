package pacman.Server;

import pacman.Server.enums.MoveDirection;

import java.awt.*;

public class Player {

    private Point localization;

    private MoveDirection currentMoveDirection;

    public Player(Point playerStartingPoint) {
        this.localization = playerStartingPoint;
        this.currentMoveDirection = MoveDirection.UP;
    }

    public Point getLocalization() {
        return localization;
    }

    public void setLocalization(Point localization) {
        this.localization = localization;
    }

    public MoveDirection getCurrentMoveDirection() {
        return currentMoveDirection;
    }

    public void setCurrentMoveDirection(MoveDirection currentMoveDirection) {
        this.currentMoveDirection = currentMoveDirection;
    }

    public void moveUP() {
        this.currentMoveDirection = MoveDirection.UP;
    }

    public void moveDOWN() {
        this.currentMoveDirection = MoveDirection.DOWN;
    }

    public void moveRIGHT() {
        this.currentMoveDirection = MoveDirection.RIGHT;
    }

    public void moveLEFT() {
        this.currentMoveDirection = MoveDirection.LEFT;
    }

}
