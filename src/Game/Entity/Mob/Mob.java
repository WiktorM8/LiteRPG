package Game.Entity.Mob;

import Game.Entity.Entity;
import Game.World.BaseWorld;
import Game.World.Enum.DirectionType;
import Game.World.Enum.Entity.EntityType;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;
import Game.World.Model.Tile;

public abstract class Mob extends Entity {
    protected DirectionType direction;
    protected MobType mobType;
    protected double strength;
    protected double health, maxHealth;
    protected double speed;
    protected int level;

    public Mob(MobType mobType, BaseWorld world, Position position, int level, double strength, double health, double speed) {
        super(EntityType.MOB, world, position);
        this.level = level;
        this.direction = DirectionType.NONE;
        this.mobType = mobType;
        this.strength = strength;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }
    public DirectionType getDirection() {
        return direction;
    }
    public MobType getMobType() {
        return mobType;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public double getStrength() {
        return strength;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public double getHealth() {
        return health;
    }
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }
    public double getMaxHealth() {
        return maxHealth;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void increaseLevel(int increment) {
        this.level += increment;
    }
    public int getLevel() {
        return level;
    }

    /**
     * Should be called every time the entity moves.
     */
    protected void checkBlockCollision() {
        int tileSize = world.getTileSize();
        int halfTileSize = tileSize / 2;

        int mobX = (int) (position.getX() + halfTileSize) / tileSize;
        int mobY = (int) (position.getY() + halfTileSize) / tileSize;

        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();

        if (mobX - 1 >= 0) {
            Tile tile = world.getTile(mobX - 1, mobY);
            if (tile.isSolid() || tile.isWater()) {
                if (position.getX() < mobX * tileSize - 1) {
                    position.setX(mobX * tileSize);
                }
            }
        }
        if (mobX + 1 < worldWidth) {
            Tile tile = world.getTile(mobX + 1, mobY);
            if (tile.isSolid() || tile.isWater()) {
                if (position.getX() + tileSize > (mobX + 1) * tileSize - 1) {
                    position.setX(mobX * tileSize);
                }
            }
        }
        if (mobY - 1 >= 0) {
            Tile tile = world.getTile(mobX, mobY - 1);
            if (tile.isSolid() || tile.isWater()) {
                if (position.getY() < mobY * tileSize - 1) {
                    position.setY(mobY * tileSize);
                }
            }
        }
        if (mobY + 1 < worldHeight) {
            Tile tile = world.getTile(mobX, mobY + 1);
            if (tile.isSolid() || tile.isWater()) {
                if (position.getY() + tileSize > (mobY + 1) * tileSize - 1) {
                    position.setY(mobY * tileSize);
                }
            }
        }
    }

}
