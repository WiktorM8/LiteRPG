package Renderer.GUI;

import Game.GameManager;
import Renderer.RenderSystem;

import java.awt.*;

public class GUIRenderer extends BaseGUIRenderer {
    private final StatusBarsRenderer healthAndManaRenderer;
    private final MinimapRenderer minimapRenderer;

    public static final int GUI_BAR_HEIGHT = 150;

    public GUIRenderer(RenderSystem renderSystem) {
        super(renderSystem);
        this.healthAndManaRenderer = new StatusBarsRenderer(renderSystem);
        this.minimapRenderer = new MinimapRenderer(renderSystem);
    }

    public void render(Graphics2D g2d, GameManager gameManager) {
        //renderGuiBar(g2d, gameManager);
        healthAndManaRenderer.render(g2d, gameManager);
        minimapRenderer.render(g2d, gameManager);
    }

    private void renderGuiBar(Graphics2D g2d, GameManager gameManager) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, gameManager.gameHeight - GUI_BAR_HEIGHT, gameManager.gameWidth, GUI_BAR_HEIGHT);
    }

}
