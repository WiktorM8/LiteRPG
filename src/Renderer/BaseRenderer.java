package Renderer;

public abstract class BaseRenderer {
    protected final RenderSystem renderSystem;

    public BaseRenderer(RenderSystem renderSystem) {
        this.renderSystem = renderSystem;
    }

    public RenderSystem getRenderSystem() {
        return renderSystem;
    }
}
