package Game.Camera;

import Game.Entity.Entity;
import Game.GameManager;
import Game.World.Model.Position;

public class WorldCamera {
    private Position position;
    private final GameManager gameManager;

    public WorldCamera(GameManager gameManager) {
        this.gameManager = gameManager;
        this.position = new Position(0, 0);
    }

    public void focusEntity(Entity focusEntity) {
        double targetX = focusEntity.getPosition().getX();
        double targetY = focusEntity.getPosition().getY();

        int tileSize = gameManager.tileSize;
        int halfTileSize = tileSize / 2;
        int screenWidth = gameManager.gameWidth;
        int screenHeight = gameManager.gameHeight;
        int worldWidthPx = gameManager.getGame().getWorld().getWidth() * gameManager.tileSize;
        int worldHeightPx = gameManager.getGame().getWorld().getHeight() * gameManager.tileSize;

        double camX = Math.max(0, Math.min(targetX - screenWidth / 2.0 + halfTileSize, worldWidthPx - screenWidth - tileSize / 2.0));
        // I have no idea why division by 4.0 works instead of 2.0, but it does
        double camY = Math.max(0, Math.min(targetY - screenHeight / 2.0 + halfTileSize, worldHeightPx - screenHeight + tileSize / 4.0));

        position.setX(camX);
        position.setY(camY);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }
}
