package Renderer;

import java.awt.*;
import java.util.Map;

import Game.Camera.WorldCamera;
import Game.Entity.Entity;
import Game.Entity.Mob.Mob;
import Game.Entity.Mob.Player;
import Game.GameManager;
import Game.World.BaseWorld;
import Renderer.Entity.MobRenderer;
import Renderer.GUI.GUIRenderer;
import Renderer.Texturer.Enum.BlockTexture;
import Renderer.Texturer.Enum.EntityTexture;
import Renderer.Texturer.Loader.BlockTextureLoader;
import Renderer.Texturer.Loader.EntityTextureLoader;
import Renderer.World.WorldRenderer;

public class RenderSystem {
    private static GameManager gameManager;
    private final MobRenderer mobRenderer;
    private final WorldRenderer worldRenderer;
    private final GUIRenderer guiRenderer;
    private final Map<EntityTexture, AnimatedTexture> entityTextures;
    private final Map<BlockTexture, AnimatedTexture> blockTextures;
    private int tileSize;
    private int scaleFactor;

    public RenderSystem(GameManager gameManager, int tileSize, int scaleFactor) {
        entityTextures = EntityTextureLoader.loadTextures(scaleFactor);
        blockTextures = BlockTextureLoader.loadTextures(scaleFactor);

        RenderSystem.gameManager = gameManager;
        mobRenderer = new MobRenderer(this);
        worldRenderer = new WorldRenderer(this);
        guiRenderer = new GUIRenderer(this);
        this.tileSize = tileSize;
        this.scaleFactor = scaleFactor;
    }

    public void render(Graphics2D g2d, Mob mob, WorldCamera camera) {
        if (mobRenderer != null) {
            mobRenderer.render(g2d, mob, camera);
        }
    }
    public void render(Graphics2D g2d, BaseWorld world) {
        if (worldRenderer != null) {
            worldRenderer.render(g2d, world);
        }
    }
    public void renderGUI(Graphics2D g2d, GameManager gameManager) {
        if (guiRenderer != null) {
            guiRenderer.render(g2d, gameManager);
        }
    }

    public void renderMobs(Graphics2D g2d, BaseWorld world) {
        WorldCamera camera = gameManager.getGame().getCamera();
        Player player = gameManager.getGame().getPlayer();
        boolean playerRendered = false;

        if (world != null) {
            for (Mob mob : world.getMobsSorted()) {
                if (!playerRendered && compareEntities(player, mob) < 0) {
                    render(g2d, player, camera);
                    playerRendered = true;
                }

                render(g2d, mob, camera);
            }

            if (!playerRendered) {
                render(g2d, player, camera);
            }
        }
    }

    private int compareEntities(Entity e1, Entity e2) {
        int cmpY = Double.compare(e1.getPosition().getY(), e2.getPosition().getY());
        if (cmpY != 0) return cmpY;
        return Double.compare(e1.getPosition().getX(), e2.getPosition().getX());
    }

    public AnimatedTexture getEntityTexture(EntityTexture texture) {
        return entityTextures.get(texture);
    }
    public AnimatedTexture getBlockTexture(BlockTexture texture) {
        return blockTextures.get(texture);
    }
    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }
    public int getTileSize() {
        return tileSize;
    }
    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }
    public int getScaleFactor() {
        return scaleFactor;
    }
}

