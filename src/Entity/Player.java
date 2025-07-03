package Entity;

import Game.World.Enum.Direction;
import Game.World.Position;

import static java.lang.Math.abs;

public class Player extends Entity {
    private static final int DEFAULT_X = 100;
    private static final int DEFAULT_Y = 100;
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_SPEED = 4;

    private Position movementPosition;

    public Player() {
        super(
            new Position(DEFAULT_X, DEFAULT_Y),
            DEFAULT_STRENGTH,
            DEFAULT_HEALTH,
            DEFAULT_SPEED
        );
        movementPosition = new Position(DEFAULT_X, DEFAULT_Y);
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
        this.position =
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

            if (abs(deltaX) > abs(deltaY)) {
                direction = deltaX > 0 ? Direction.RIGHT : Direction.LEFT;
            } else {
                direction = deltaY > 0 ? Direction.DOWN : Direction.UP;
            }
        } else {
            direction = Direction.NONE; // No movement, reset direction
        }
    }

    @Override
    public void update() {
        move();
    }
}
