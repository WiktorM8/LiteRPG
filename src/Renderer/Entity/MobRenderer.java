package Renderer.Entity;

import Game.Camera.WorldCamera;
import Game.Entity.Mob.Mob;
import Game.World.Model.Position;
import Renderer.AnimatedTexture;
import Renderer.RenderSystem;
import Renderer.Texturer.Model.EntityTextures;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MobRenderer extends BaseMobRenderer {
    private static final String FONT_NAME = "Arial";
    private static final int FONT_SIZE = 10;
    private static final String LEVEL_TEXT = "lv. ";
    private static final double HEALTH_BAR_TILE_WIDTH_PERCENTAGE = 0.8; // 80% of tile width

    public MobRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }

    @Override
    public void render(Graphics2D g2d, Mob mob, WorldCamera camera, int tileSize) {
        EntityTextures textures = mob.getMobType().getTexture();
        AnimatedTexture currentTexture = switch (mob.getDirection()) {
            case NONE -> renderSystem.getEntityTexture(textures.getStandingTexture());
            case DOWN -> renderSystem.getEntityTexture(textures.getWalkingDownTexture());
            case UP -> renderSystem.getEntityTexture(textures.getWalkingUpTexture());
            case LEFT -> renderSystem.getEntityTexture(textures.getWalkingLeftTexture());
            case RIGHT -> renderSystem.getEntityTexture(textures.getWalkingRightTexture());
            default -> throw new IllegalStateException("Unexpected value: " + mob.getDirection());
        };

        BufferedImage frame = currentTexture.getFrame(mob.getAnimationState().getCurrentFrameIndex(currentTexture));
        Position pos = mob.getPosition();

        g2d.drawImage(
                frame,
                (int) (pos.getX() - camera.getPosition().getX()),
                (int) (pos.getY() - camera.getPosition().getY()),
                null
        );

        if (!(mob instanceof Game.Entity.Mob.Player)) {
            // Draw level above the mob
            String levelText = LEVEL_TEXT + mob.getLevel();
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
            g2d.drawString(
                    levelText,
                    (int) (pos.getX() - camera.getPosition().getX() + tileSize / 2.0 -
                            g2d.getFontMetrics().stringWidth(levelText) / 2.0),
                    (int) (pos.getY() - camera.getPosition().getY() + tileSize + FONT_SIZE)
            );

            int healthBarWidth = (int) (tileSize * HEALTH_BAR_TILE_WIDTH_PERCENTAGE);
            int offsetX = tileSize / 2 - healthBarWidth / 2;

            // Draw health bar above the mob
            if (mob.getHealth() < mob.getMaxHealth()) {
                double healthPercentage = mob.getHealth() / mob.getMaxHealth();
                int healthWidth = (int) (healthBarWidth * healthPercentage);
                g2d.setColor(Color.GRAY);
                g2d.fillRect(
                        (int) (pos.getX() - camera.getPosition().getX() + offsetX),
                        (int) (pos.getY() - camera.getPosition().getY() - 10),
                        healthBarWidth,
                        5
                );
                g2d.setColor(Color.RED);
                g2d.fillRect(
                        (int) (pos.getX() - camera.getPosition().getX() + offsetX),
                        (int) (pos.getY() - camera.getPosition().getY() - 10),
                        healthWidth,
                        5
                );
            }
        }
    }
}
