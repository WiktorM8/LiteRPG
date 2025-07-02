package Renderer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import Entity.Entity;

public class RenderSystem {
    private final Map<Class<?>, EntityRendererInterface<?>> renderers = new HashMap<>();

    public <EntityType extends Entity> void registerRenderer(Class<EntityType> clazz, EntityRendererInterface<EntityType> renderer) {
        renderers.put(clazz, renderer);
    }

    @SuppressWarnings("unchecked")
    public void render(Graphics2D g2d, Entity entity) {
        EntityRendererInterface<Entity> renderer = (EntityRendererInterface<Entity>) renderers.get(entity.getClass());
        if (renderer != null) {
            renderer.render(g2d, entity);
        }
    }
}

