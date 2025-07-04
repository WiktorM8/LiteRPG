package Game.World.Worlds;

import Game.GameManager;
import Game.World.BaseWorld;
import Game.World.Model.Tile;

public class SunnyFields extends BaseWorld {

    public SunnyFields(GameManager gameManager, int width, int height, int spawnX, int spawnY, Tile[][] map) {
        super(gameManager, width, height, spawnX, spawnY, map);
    }
}
