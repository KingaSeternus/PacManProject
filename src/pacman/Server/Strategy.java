package pacman.Server;

import pacman.Server.enums.BoardObject;
import pacman.Server.enums.MoveDirection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Strategy {

    static void determineMoveStrategyForEnemy(Enemy enemy, Map map, Point playerPosition, Boolean isRunningTime) {
        List<PossibleMove> possibleMoves = retrievePossibleMoves(enemy.getLocalization(), map, playerPosition);
        PossibleMove bestPossibleMove;
        int throwDice = new Random().nextInt(12);

        if (isRunningTime) {
            if (throwDice < 8) {
                bestPossibleMove = runAwayStrategy(possibleMoves);
            } else {
                bestPossibleMove = getRandomPossibleMove(possibleMoves);
            }
        } else {
            if (throwDice < 4) {
                bestPossibleMove = followCurrentPathStrategy(possibleMoves, enemy.getCurrentMoveDirection());
            } else if (throwDice < 8) {
                bestPossibleMove = followPlayerStrategy(possibleMoves);
            } else {
                bestPossibleMove = getRandomPossibleMove(possibleMoves);
            }
        }

        assignPossibleMoveToEnemy(enemy, bestPossibleMove);
    }

    private static PossibleMove runAwayStrategy(List<PossibleMove> possibleMoves) {
        double bestDistanceToPlayer = 0;
        PossibleMove bestPossibleMove = null;
        for (PossibleMove possibleMove : possibleMoves) {
            if (possibleMove.getDistanceToPlayer() > bestDistanceToPlayer) {
                bestPossibleMove = possibleMove;
                bestDistanceToPlayer = possibleMove.getDistanceToPlayer();
            }
        }
        return bestPossibleMove != null ? bestPossibleMove : getRandomPossibleMove(possibleMoves);
    }

    private static PossibleMove followCurrentPathStrategy(List<PossibleMove> possibleMoves, MoveDirection enemyMoveDirection) {
        for (PossibleMove possibleMove : possibleMoves) {
            if (enemyMoveDirection == possibleMove.getDirection()) {
                return possibleMove;
            }
        }
        return getRandomPossibleMove(possibleMoves);
    }

    private static PossibleMove followPlayerStrategy(List<PossibleMove> possibleMoves) {
        double bestDistanceToPlayer = 100;
        PossibleMove bestPossibleMove = null;
        for (PossibleMove possibleMove : possibleMoves) {
            if (possibleMove.getDistanceToPlayer() < bestDistanceToPlayer) {
                bestPossibleMove = possibleMove;
                bestDistanceToPlayer = possibleMove.getDistanceToPlayer();
            }
        }
        return bestPossibleMove != null ? bestPossibleMove : getRandomPossibleMove(possibleMoves);
    }

    private static PossibleMove getRandomPossibleMove(List<PossibleMove> possibleMoves) {
        return possibleMoves.get(new Random().nextInt(possibleMoves.size()));
    }

    private static void assignPossibleMoveToEnemy(Enemy enemy, PossibleMove possibleMove) {
        enemy.setCurrentMoveDirection(possibleMove.getDirection());
        enemy.setLocalization(possibleMove.getPlace());
        enemy.setDistanceToPlayer(possibleMove.getDistanceToPlayer());
    }

    private static java.util.List<PossibleMove> retrievePossibleMoves(Point currentLocation, Map map, Point playerPosition) {
        List<PossibleMove> possibleMoves = new ArrayList<>();
        for (MoveDirection moveDirection : MoveDirection.values()) {
            PossibleMove possibleMove = PossibleMove.retrievePossibleMove(moveDirection, currentLocation, map, playerPosition);
            if (possibleMove.getFieldValue() != BoardObject.WALL) {
                possibleMoves.add(possibleMove);
            }
        }
        return possibleMoves;
    }

    static class PossibleMove {
        private MoveDirection direction;
        private Point place;
        private BoardObject fieldValue;
        private double distanceToPlayer;

        private PossibleMove(MoveDirection direction, Point place, BoardObject fieldValue, double distanceToPlayer) {
            this.direction = direction;
            this.place = place;
            this.fieldValue = fieldValue;
            this.distanceToPlayer = distanceToPlayer;
        }

        static PossibleMove retrievePossibleMove(MoveDirection direction, Point currentLocation, Map map, Point playerPosition) {
            Point newPoint = new Point(currentLocation.x + direction.getChangeInX(), currentLocation.y + direction.getChangeInY());
            double distance = newPoint.distance(playerPosition);
            return new PossibleMove(direction, newPoint, map.getBoardObjectAtPoint(newPoint), distance);
        }

        public MoveDirection getDirection() {
            return direction;
        }

        public Point getPlace() {
            return place;
        }

        public BoardObject getFieldValue() {
            return fieldValue;
        }

        public double getDistanceToPlayer() {
            return distanceToPlayer;
        }
    }
}
