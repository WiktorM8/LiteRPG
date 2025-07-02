package Renderer;

import Entity.Player;

import java.awt.*;

public class PlayerRenderer implements EntityRendererInterface<Player> {
    @Override
    public void render(Graphics2D g2d, Player player) {
        g2d.setColor(Color.GREEN);
        int size = 48;
        g2d.fillOval((int) player.getPosition().getX(), (int) player.getPosition().getY(), size, size);
    }
}
