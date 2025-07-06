package Game.World.Worlds;

import Game.Entity.Mob.Enemy.Bandit;
import Game.GameManager;
import Game.World.BaseWorld;
import Game.World.Model.Tile;

public class SunnyFields extends BaseWorld {

    public SunnyFields(GameManager gameManager, int width, int height, int spawnX, int spawnY, Tile[][] map) {
        super(gameManager, width, height, spawnX, spawnY, map);

        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * width * gameManager.tileSize);
            int y = (int) (Math.random() * height * gameManager.tileSize);
            int level = (int) (Math.random() * 5) + 1; // Random level between 1 and 5
            Bandit bandit = new Bandit(
                this,
                new Game.World.Model.Position(x, y),
                level
            );
            this.addMob(bandit);
        }
    }
}
