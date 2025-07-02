package Entity;

import Game.World.Position;

public class Player extends Entity {
    private final int DEFAULT_X = 100;
    private final int DEFAULT_Y = 100;
    private final int DEFAULT_STRENGTH = 10;
    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_SPEED = 5;

    private Position movementPosition;

    public Player() {
        initializePlayer();
    }

    public void setPlayerMovementPosition(double x, double y) {
        this.movementPosition = new Position(x, y);
    }
    public void setPlayerMovementPosition(Position position) {
        this.movementPosition = position;
    }
    public Position getPlayerMovementPosition() {
        return movementPosition;
    }

    private void initializePlayer() {
        this.position = new Position(DEFAULT_X, DEFAULT_Y);
        this.movementPosition = new Position(DEFAULT_X, DEFAULT_Y);
        this.strength = DEFAULT_STRENGTH;
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }

    private void move() {
        if (!position.isPositionSame(movementPosition)) {
            double deltaX = movementPosition.getX() - position.getX();
            double deltaY = movementPosition.getY() - position.getY();
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

            if (distance > speed) {
                double ratio = speed / distance;
                position.setX(position.getX() + deltaX * ratio);
                position.setY(position.getY() + deltaY * ratio);
            } else {
                position.setX(movementPosition.getX());
                position.setY(movementPosition.getY());
            }
        }
    }

    @Override
    public void update() {
        move();
    }
}
