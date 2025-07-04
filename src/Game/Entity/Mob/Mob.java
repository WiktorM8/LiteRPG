package Game.Entity.Mob;

import Game.Entity.Entity;
import Game.World.Enum.DirectionType;
import Game.World.Enum.Entity.EntityType;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;

public abstract class Mob extends Entity {
    protected DirectionType direction;
    protected MobType mobType;
    protected double strength;
    protected double health;
    protected double speed;

    public Mob(MobType mobType, Position position, double strength, double health, double speed) {
        super(EntityType.MOB, position, strength, health, speed);
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

    }
}
