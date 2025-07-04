package Renderer.GUI;

import Game.GameManager;
import Renderer.RenderSystem;

import java.awt.*;

public class HealthAndManaRenderer extends BaseGUIRenderer {
    public static final int HEALTH_BAR_X = 40;
    public static final int HEALTH_BAR_Y = 140;
    public static final int HEALTH_BAR_WIDTH = 150;
    public static final int HEALTH_BAR_HEIGHT = 30;

    public static final int MANA_BAR_X = 40;
    public static final int MANA_BAR_Y = 100;
    public static final int MANA_BAR_WIDTH = 150;
    public static final int MANA_BAR_HEIGHT = 30;

    public static final int BORDER = 2;
    public static final String FONT_NAME = "Arial";
    public static final int FONT_SIZE = 16;

    public HealthAndManaRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }

    public void render(Graphics2D g2d, GameManager gameManager) {
        renderHealthBar(g2d, gameManager);
        renderManaBar(g2d, gameManager);
    }

    public void renderHealthBar(Graphics2D g2d, GameManager gameManager) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(
                HEALTH_BAR_X - 2, gameManager.gameHeight - HEALTH_BAR_Y - 2,
                HEALTH_BAR_WIDTH + BORDER * 2, HEALTH_BAR_HEIGHT + BORDER * 2
        );
        g2d.setColor(Color.GRAY);
        g2d.fillRect(
                HEALTH_BAR_X, gameManager.gameHeight - HEALTH_BAR_Y,
                HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT
        );

        double currentHealth = gameManager.getGame().getPlayer().getHealth();
        double maxHealth = gameManager.getGame().getPlayer().getMaxHealth();
        double healthPercent = Math.max(0.0, Math.min(1.0, currentHealth / maxHealth));

        g2d.setColor(Color.RED);
        g2d.fillRect(
                HEALTH_BAR_X, gameManager.gameHeight - HEALTH_BAR_Y,
                (int) (healthPercent * HEALTH_BAR_WIDTH), HEALTH_BAR_HEIGHT
        );

        g2d.setColor(Color.BLACK);
        String text = (int)currentHealth + " / " + (int)maxHealth;

        Font font = new Font(FONT_NAME, Font.BOLD, FONT_SIZE);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getAscent();

        int textX = HEALTH_BAR_X + (HEALTH_BAR_WIDTH - textWidth) / 2;
        int textY = gameManager.gameHeight - HEALTH_BAR_Y + (HEALTH_BAR_HEIGHT + textHeight) / 2 - 2;

        g2d.drawString(text, textX, textY);
    }

    public void renderManaBar(Graphics2D g2d, GameManager gameManager) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(
                MANA_BAR_X - 2, gameManager.gameHeight - MANA_BAR_Y - 2,
                MANA_BAR_WIDTH + BORDER * 2, MANA_BAR_HEIGHT + BORDER * 2
        );
        g2d.setColor(Color.GRAY);
        g2d.fillRect(
                MANA_BAR_X, gameManager.gameHeight - MANA_BAR_Y,
                MANA_BAR_WIDTH, MANA_BAR_HEIGHT
        );

        double currentMana = gameManager.getGame().getPlayer().getMana();
        double maxMana = gameManager.getGame().getPlayer().getMaxMana();
        double manaPercent = Math.max(0.0, Math.min(1.0, currentMana / maxMana));

        g2d.setColor(Color.BLUE);
        g2d.fillRect(
                MANA_BAR_X, gameManager.gameHeight - MANA_BAR_Y,
                (int) (manaPercent * MANA_BAR_WIDTH), MANA_BAR_HEIGHT
        );

        g2d.setColor(Color.BLACK);
        String text = (int)currentMana + " / " + (int)maxMana;

        Font font = new Font(FONT_NAME, Font.BOLD, FONT_SIZE);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getAscent();

        int textX = MANA_BAR_X + (MANA_BAR_WIDTH - textWidth) / 2;
        int textY = gameManager.gameHeight - MANA_BAR_Y + (MANA_BAR_HEIGHT + textHeight) / 2 - 2;

        g2d.drawString(text, textX, textY);
    }
}
