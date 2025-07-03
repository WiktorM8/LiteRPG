package Entity;

import Game.World.Enum.Direction;
import Game.World.Position;
import Renderer.AnimationState;

public abstract class Entity {
    protected AnimationState animationState;
    protected Position position;
    protected Direction direction;
    protected double strength;
    protected double health;
    protected double speed;

    public Entity(Position position, double strength, double health, double speed) {
        this.animationState = new AnimationState();
        this.position = position;
        this.direction = Direction.NONE;
        this.strength = strength;
        this.health = health;
        this.speed = speed;
    }

    public abstract void update();

    public void setAnimationState(AnimationState animationState) {
        this.animationState = animationState;
    }
    public AnimationState getAnimationState() {
        return animationState;
    }
    public void setPosition(double x, double y) {
        this.position = new Position(x, y);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Direction getDirection() {
        return direction;
    }
    public Position getPosition() {
        return position;
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
}
