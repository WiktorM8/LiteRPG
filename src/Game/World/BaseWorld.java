package Game.World;

import Game.Entity.Mob.Player;
import Game.GameManager;
import Game.World.Model.Tile;

public abstract class BaseWorld {
    protected GameManager gameManager;
    /**
     * Describes the dimensions of the world in tiles.
     */
    protected int width, height;
    protected int spawnX, spawnY;
    protected Tile[][] map;

    public BaseWorld(GameManager gameManager, int width, int height, int spawnX, int spawnY, Tile[][] map) {
        this.gameManager = gameManager;
        this.width = width;
        this.height = height;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.map = map;
    }


    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    public GameManager getGameManager() {
        return gameManager;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }
    public int getSpawnX() {
        return spawnX;
    }
    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }
    public int getSpawnY() {
        return spawnY;
    }
    public void setMap(Tile[][] map) {
        this.map = map;
    }
    public Tile[][] getMap() {
        return map;
    }
    public Tile getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return null;
        }
        return map[y][x];
    }
    public Player getPlayer() {
        return gameManager.getGame().getPlayer();
    }
}
