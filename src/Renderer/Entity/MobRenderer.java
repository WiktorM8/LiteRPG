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
    public MobRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }

    @Override
    public void render(Graphics2D g2d, Mob mob, WorldCamera camera) {
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
    }
}
