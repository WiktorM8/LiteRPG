package Renderer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import Game.Entity.Entity;
import Game.World.BaseWorld;
import Renderer.Entity.EntityRendererInterface;
import Renderer.Texturer.Enum.BlockTexture;
import Renderer.Texturer.Enum.EntityTexture;
import Renderer.Texturer.Loader.BlockTextureLoader;
import Renderer.Texturer.Loader.EntityTextureLoader;
import Renderer.World.WorldRenderer;

public class RenderSystem {
    private final Map<Class<?>, EntityRendererInterface<?>> entityRenderers = new HashMap<>();
    private final WorldRenderer worldRenderer;
    private final Map<EntityTexture, AnimatedTexture> entityTextures;
    private final Map<BlockTexture, AnimatedTexture> blockTextures;
    private int tileSize;
    private int scaleFactor;

    public RenderSystem(int tileSize, int scaleFactor) {
        entityTextures = EntityTextureLoader.loadTextures();
        blockTextures = BlockTextureLoader.loadTextures();

        worldRenderer = new WorldRenderer(this);
        this.tileSize = tileSize;
        this.scaleFactor = scaleFactor;
    }

    public <EntityType extends Entity> void registerRenderer(Class<EntityType> clazz, EntityRendererInterface<EntityType> renderer) {
        entityRenderers.put(clazz, renderer);
    }

    @SuppressWarnings("unchecked")
    public void render(Graphics2D g2d, Entity entity) {
        EntityRendererInterface<Entity> renderer = (EntityRendererInterface<Entity>) entityRenderers.get(entity.getClass());
        if (renderer != null) {
            renderer.render(g2d, entity);
        }
    }
    public void render(Graphics2D g2d, BaseWorld world) {
        if (worldRenderer != null) {
            worldRenderer.render(g2d, world);
        }
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

