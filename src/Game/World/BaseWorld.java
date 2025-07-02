package Game.World;

import Entity.Player;

public abstract class BaseWorld {
    protected Player player;

    public BaseWorld(Player player) {
        this.player = player;
    }
}
