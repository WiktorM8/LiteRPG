package Renderer.Entity;

import Game.Entity.Entity;

import java.awt.*;

public interface EntityRendererInterface<EntityType extends Entity> {
    void render(Graphics2D g2d, EntityType entity);
}
