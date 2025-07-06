package Renderer.Entity;

import Game.Camera.WorldCamera;
import Game.Entity.Mob.Mob;

import java.awt.*;

public interface MobRendererInterface {
    void render(Graphics2D g2d, Mob mob, WorldCamera camera);
}
