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
    protected double health;
    protected double speed;

    public Mob(MobType mobType, BaseWorld world, Position position, double strength, double health, double speed) {
        super(EntityType.MOB, world, position);
        this.direction = DirectionType.NONE;
        this.mobType = mobType;
        this.strength = strength;
        this.health = health;
        this.speed = speed;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }
    public DirectionType getDirection() {
        return direction;
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
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
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
