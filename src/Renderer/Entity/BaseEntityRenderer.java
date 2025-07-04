package Renderer.Entity;

import Game.Entity.Entity;
import Renderer.BaseRenderer;
import Renderer.RenderSystem;

public abstract class BaseEntityRenderer<EntityClass extends Entity> extends BaseRenderer implements EntityRendererInterface<EntityClass> {
    public BaseEntityRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }
}
