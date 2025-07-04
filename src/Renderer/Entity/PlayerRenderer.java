package Renderer.Entity;

import Game.Camera.WorldCamera;
import Game.Entity.Mob.Player;
import Game.World.Enum.DirectionType;
import Game.World.Enum.Entity.EntityType;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;
import Renderer.AnimatedTexture;
import Renderer.RenderSystem;
import Renderer.Texturer.Model.EntityTextures;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerRenderer extends BaseEntityRenderer<Player> {
    private final AnimatedTexture standingTexture;
    private final AnimatedTexture walkingDownTexture;
    private final AnimatedTexture walkingUpTexture;
    private final AnimatedTexture walkingLeftTexture;
    private final AnimatedTexture walkingRightTexture;

    public PlayerRenderer(RenderSystem renderSystem) {
        super(renderSystem);
        EntityTextures textures = MobType.PLAYER.getTexture();
        this.standingTexture = renderSystem.getEntityTexture(textures.getStandingTexture());
        this.walkingDownTexture = renderSystem.getEntityTexture(textures.getWalkingDownTexture());
        this.walkingUpTexture = renderSystem.getEntityTexture(textures.getWalkingUpTexture());
        this.walkingLeftTexture = renderSystem.getEntityTexture(textures.getWalkingLeftTexture());
        this.walkingRightTexture = renderSystem.getEntityTexture(textures.getWalkingRightTexture());
    }

    @Override
    public void render(Graphics2D g2d, Player player) {
        DirectionType playerDirection = player.getDirection();
        AnimatedTexture currentTexture = switch (playerDirection) {
            case NONE -> standingTexture;
            case DOWN -> walkingDownTexture;
            case UP -> walkingUpTexture;
            case LEFT -> walkingLeftTexture;
            case RIGHT -> walkingRightTexture;
            default -> throw new IllegalStateException("Unexpected value: " + playerDirection);
        };
        BufferedImage frame = currentTexture.getFrame(player.getAnimationState().getCurrentFrameIndex(currentTexture));
        Position pos = player.getPosition();

        WorldCamera camera = player.getGameManager().getGame().getCamera();

        g2d.drawImage(
                frame,
                (int) (pos.getX() - camera.getPosition().getX()),
                (int) (pos.getY() - camera.getPosition().getY()),
                null
        );
    }
}
