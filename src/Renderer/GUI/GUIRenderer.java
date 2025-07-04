package Renderer.GUI;

import Game.GameManager;
import Renderer.RenderSystem;

import java.awt.*;

public class GUIRenderer extends BaseGUIRenderer {
    private final MinimapRenderer minimapRenderer;

    public GUIRenderer(RenderSystem renderSystem) {
        super(renderSystem);
        this.minimapRenderer = new MinimapRenderer(renderSystem);
    }

    public void render(Graphics2D g2d, GameManager gameManager) {
        minimapRenderer.render(g2d, gameManager);
    }

}
