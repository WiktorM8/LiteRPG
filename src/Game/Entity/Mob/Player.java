package Game.Entity.Mob;

import Game.GameManager;
import Game.World.BaseWorld;
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
    private static final int DEFAULT_MANA = 100;
    private static final int DEFAULT_SPEED = 4;

    private GameManager gameManager;
    private Position movementPosition;
    private double mana;
    private double maxMana;
    private double experience;
    private double experienceToNextLevel;

    public Player(GameManager gameManager, BaseWorld world) {
        super(
            MobType.PLAYER,
            world,
            new Position(DEFAULT_X, DEFAULT_Y),
            DEFAULT_STRENGTH,
            DEFAULT_HEALTH,
            DEFAULT_SPEED
        );
        this.gameManager = gameManager;
        movementPosition = new Position(DEFAULT_X, DEFAULT_Y);
        this.mana = DEFAULT_MANA;
        this.maxMana = DEFAULT_MANA;
        this.experience = 0;
        /**
         * @todo Implement a dynamic experience system
         */
        this.experienceToNextLevel = 100; // Initial experience required for the first level up
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
    public void setMana(double mana) {
        this.mana = mana;
    }
    public double getMana() {
        return mana;
    }
    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }
    public double getMaxMana() {
        return maxMana;
    }
    public void setExperience(double experience) {
        this.experience = experience;
        if (this.experience >= experienceToNextLevel) {
            levelUp();
        }
    }
    public void addExperience(double experience) {
        this.experience += experience;
        if (this.experience >= experienceToNextLevel) {
            levelUp();
        }
    }
    public double getExperience() {
        return experience;
    }
    public void setExperienceToNextLevel(double experienceToNextLevel) {
        this.experienceToNextLevel = experienceToNextLevel;
    }
    public double getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

    private void levelUp() {
        this.experience -= experienceToNextLevel; // Reset experience after leveling up
        /**
         * @todo Implement level-up logic
         */
        this.maxMana += 10; // Example: increase max mana by 10
        this.mana = this.maxMana; // Restore mana to max after leveling up
        this.strength += 5; // Example: increase strength by 5
        this.maxHealth += 20; // Example: increase health by 20
        experienceToNextLevel *= 1.2; // Increase the required experience for the next level
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

            // Check for block collision
            checkBlockCollision();
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
