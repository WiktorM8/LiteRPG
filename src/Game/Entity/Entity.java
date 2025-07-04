package Game.Entity;

import Game.World.BaseWorld;
import Game.World.Enum.Entity.EntityType;
import Game.World.Model.Position;
import Renderer.AnimationState;

public abstract class Entity {
    protected final EntityType entityType;
    protected AnimationState animationState;
    protected BaseWorld world;
    protected Position position;

    public Entity(EntityType entityType, BaseWorld world, Position position) {
        this.entityType = entityType;
        this.animationState = new AnimationState();
        this.world = world;
        this.position = position;

    }

    public abstract void update();

    public void setAnimationState(AnimationState animationState) {
        this.animationState = animationState;
    }
    public AnimationState getAnimationState() {
        return animationState;
    }
    public void setWorld(BaseWorld world) {
        this.world = world;
    }
    public BaseWorld getWorld() {
        return world;
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
