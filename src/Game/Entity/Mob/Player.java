package Game.Entity.Mob;

import Game.GameManager;
import Game.World.Enum.DirectionType;
import Game.World.Enum.Entity.EntityType;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;

import static java.lang.Math.abs;

public class Player extends Mob {
    private static final int DEFAULT_X = 0;
    private static final int DEFAULT_Y = 0;
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_SPEED = 4;

    private GameManager gameManager;
    private Position movementPosition;

    public Player(GameManager gameManager) {
        super(
            MobType.PLAYER,
            new Position(DEFAULT_X, DEFAULT_Y),
            DEFAULT_STRENGTH,
            DEFAULT_HEALTH,
            DEFAULT_SPEED
        );
        this.gameManager = gameManager;
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
                direction = deltaX > 0 ? DirectionType.RIGHT : DirectionType.LEFT;
            } else {
                direction = deltaY > 0 ? DirectionType.DOWN : DirectionType.UP;
            }
        } else {
            direction = DirectionType.NONE; // No movement, reset direction
        }
    }

    @Override
    public void update() {
        move();
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    public GameManager getGameManager() {
        return gameManager;
    }
}
