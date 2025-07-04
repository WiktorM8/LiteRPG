package Renderer.World;

import Renderer.RenderSystem;

public abstract class BaseWorldRenderer {
    protected final RenderSystem renderSystem;

    public BaseWorldRenderer(RenderSystem renderSystem) {
        this.renderSystem = renderSystem;
    }

    public RenderSystem getRenderSystem() {
        return renderSystem;
    }
}
