package Renderer.Entity;

import Renderer.BaseRenderer;
import Renderer.RenderSystem;

public abstract class BaseMobRenderer extends BaseRenderer implements MobRendererInterface {
    public BaseMobRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }
}
