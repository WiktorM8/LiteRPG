package Renderer;

import Entity.Player;
import Framework.Event.Enum.World.Direction;
import Game.World.Position;
import Renderer.Utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerRenderer implements EntityRendererInterface<Player> {
    private final AnimatedTexture standingTexture;
    private final AnimatedTexture walkingDownTexture;
    private final AnimatedTexture walkingUpTexture;
    private final AnimatedTexture walkingLeftTexture;
    private final AnimatedTexture walkingRightTexture;
    private int scaleFactor;

    public PlayerRenderer(int scaleFactor) {
        this.standingTexture = new AnimatedTexture("/entity/player/standing");
        this.walkingDownTexture = new AnimatedTexture("/entity/player/walking_down");
        this.walkingUpTexture = new AnimatedTexture("/entity/player/walking_up");
        this.walkingLeftTexture = new AnimatedTexture("/entity/player/walking_left");
        this.walkingRightTexture = new AnimatedTexture("/entity/player/walking_right");

        this.scaleFactor = scaleFactor;
    }

    @Override
    public void render(Graphics2D g2d, Player player) {
        Direction playerDirection = player.getDirection();
        AnimatedTexture currentTexture = switch (playerDirection) {
            case NONE -> standingTexture;
            case DOWN -> walkingDownTexture;
            case UP -> walkingUpTexture;
            case LEFT -> walkingLeftTexture;
            case RIGHT -> walkingRightTexture;
            default -> throw new IllegalStateException("Unexpected value: " + playerDirection);
        };
        BufferedImage frame = currentTexture.getFrame(player.getAnimationState().getCurrentFrameIndex(currentTexture));
        BufferedImage scaledFrame = ImageUtils.scaleImage(frame, scaleFactor);
        Position pos = player.getPosition();
        g2d.drawImage(scaledFrame, (int) pos.getX(), (int) pos.getY(), null);
    }
}
