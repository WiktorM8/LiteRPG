package Renderer.World;

import Game.World.BaseWorld;
import Game.World.Model.Position;
import Game.World.Model.Tile;
import Renderer.AnimatedTexture;
import Renderer.RenderSystem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WorldRenderer extends BaseWorldRenderer {

    public WorldRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }

    public void render(Graphics2D g2d, BaseWorld world) {
        int tileSize = renderSystem.getTileSize();
        int scaleFactor = renderSystem.getScaleFactor();

        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();

        int screenWidth = world.getGameManager().gameWidth;
        int screenHeight = world.getGameManager().gameHeight;

        Position cameraPosition = world.getGameManager().getGame().getCamera().getPosition();
        int cameraX = (int) cameraPosition.getX();
        int cameraY = (int) cameraPosition.getY();

        int startTileX = Math.max(0, cameraX / tileSize - 1);
        int startTileY = Math.max(0, cameraY / tileSize - 1);
        int endTileX = Math.min((cameraX + screenWidth) / tileSize + 1, worldWidth);
        int endTileY = Math.min((cameraY + screenHeight) / tileSize + 1, worldHeight);


        for (int y = startTileY; y <= endTileY; y++) {
            for (int x = startTileX; x <= endTileX; x++) {
                Tile tile = world.getTile(x, y);
                if (tile != null) {
                    AnimatedTexture texture = renderSystem.getBlockTexture(tile.getBlockType().getTexture());
                    BufferedImage frame = texture.getFrame(0);

                    int screenX = x * tileSize - cameraX;
                    int screenY = y * tileSize - cameraY;

                    g2d.drawImage(frame, screenX, screenY, null);
                }
            }
        }
    }
}
