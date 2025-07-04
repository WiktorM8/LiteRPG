package Game.Entity;

import Game.World.Enum.Entity.EntityType;
import Game.World.Model.Position;
import Renderer.AnimationState;

public abstract class Entity {
    protected final EntityType entityType;
    protected AnimationState animationState;
    protected Position position;

    public Entity(EntityType entityType, Position position, double strength, double health, double speed) {
        this.entityType = entityType;
        this.animationState = new AnimationState();
        this.position = position;

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
    public Position getPosition() {
        return position;
    }
}
