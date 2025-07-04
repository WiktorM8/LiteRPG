package Renderer.GUI;

import Game.GameManager;
import Game.World.Enum.BlockType;
import Game.World.Model.Tile;
import Renderer.RenderSystem;

import java.awt.*;

public class MinimapRenderer extends BaseGUIRenderer {
    private static final int MINIMAP_WIDTH = 41;
    private static final int MINIMAP_HEIGHT = 41;
    private static final int MINIMAP_SCALE = 4;
    private static final int MINIMAP_MARGIN = 40;

    public MinimapRenderer(RenderSystem renderSystem) {
        super(renderSystem);
    }

    public void render(Graphics2D g2d, GameManager gameManager) {
        int screenWidth = gameManager.gameWidth;
        int screenHeight = gameManager.gameHeight;

        // Calculate the position of the minimap
        int minimapX = screenWidth - MINIMAP_WIDTH * MINIMAP_SCALE - MINIMAP_MARGIN;
        int minimapY = screenHeight - MINIMAP_HEIGHT * MINIMAP_SCALE - MINIMAP_MARGIN;

        // Draw the minimap background
        drawMinimapBorder(g2d, minimapX, minimapY);
        g2d.setColor(BlockType.SKY.getColor().toAWTColor());
        g2d.fillRect(minimapX, minimapY, MINIMAP_WIDTH * MINIMAP_SCALE, MINIMAP_HEIGHT * MINIMAP_SCALE);
        drawMinimapContent(g2d, gameManager, minimapX, minimapY);
    }

    private void drawMinimapBorder(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x - 2, y - 2, MINIMAP_WIDTH * MINIMAP_SCALE + 4, MINIMAP_HEIGHT * MINIMAP_SCALE + 4);
    }

    private void drawMinimapContent(Graphics2D g2d, GameManager gameManager, int minimapX, int minimapY) {
        drawWorldOnMinimap(g2d, gameManager, minimapX, minimapY);
    }

    private void drawWorldOnMinimap(Graphics2D g2d, GameManager gameManager, int minimapX, int minimapY) {
        int tileSize = gameManager.tileSize;
        int halfTileSize = tileSize / 2;
        int playerX = (int) (gameManager.getGame().getPlayer().getPosition().getX() + halfTileSize) / tileSize;
        int playerY = (int) (gameManager.getGame().getPlayer().getPosition().getY() + halfTileSize) / tileSize;

        for (int y = playerY - MINIMAP_HEIGHT / 2, i = 0; y <= playerY + MINIMAP_HEIGHT / 2; y++, i++) {
            for (int x = playerX - MINIMAP_WIDTH / 2, j = 0; x <= playerX + MINIMAP_WIDTH / 2; x++, j++) {
                // Get the block at the current position
                Tile tile = gameManager.getGame().getWorld().getTile(x, y);
                if (tile != null) {
                    // Draw the block on the minimap
                    g2d.setColor(tile.getBlockType().getColor().toAWTColor());
                    g2d.fillRect(minimapX + j * MINIMAP_SCALE, minimapY + i * MINIMAP_SCALE, MINIMAP_SCALE, MINIMAP_SCALE);
                }

                if (y == playerY && x == playerX) {
                    g2d.setColor(gameManager.getGame().getPlayer().getMobType().getColor().toAWTColor());
                    g2d.fillRect(minimapX + j * MINIMAP_SCALE, minimapY + i * MINIMAP_SCALE, MINIMAP_SCALE, MINIMAP_SCALE);
                }
            }
        }
    }
}
