package pacman.Server;

import pacman.Server.enums.EnemyType;
import pacman.Server.enums.MoveDirection;

import java.awt.*;

public class Enemy {

    private Point localization;

    private MoveDirection currentMoveDirection;

    private EnemyType type;

    private double distanceToPlayer;

    public Enemy(EnemyType type, Point enemyStartingPoints) {
        this.type = type;
        this.localization = enemyStartingPoints;
        this.currentMoveDirection = MoveDirection.UP;
        this.distanceToPlayer = 100;
    }

    public EnemyType getType() {
        return type;
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

    public double getDistanceToPlayer() {
        return distanceToPlayer;
    }

    public void setDistanceToPlayer(double distanceToPlayer) {
        this.distanceToPlayer = distanceToPlayer;
    }
}
