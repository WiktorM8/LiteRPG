package Renderer.Entity;

import Game.Entity.Entity;
import Renderer.RenderSystem;

public abstract class BaseEntityRenderer<EntityClass extends Entity> implements EntityRendererInterface<EntityClass> {
    protected final RenderSystem renderSystem;

    public BaseEntityRenderer(RenderSystem renderSystem) {
        this.renderSystem = renderSystem;
    }

    public RenderSystem getRenderSystem() {
        return renderSystem;
    }
}
