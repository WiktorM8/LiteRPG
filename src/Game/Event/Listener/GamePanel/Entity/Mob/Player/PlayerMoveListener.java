package Game.Event.Listener.GamePanel.Entity.Mob.Player;

import Framework.Event.Listener.AbstractEventListener;
import Game.Entity.Mob.Player;
import Game.Event.Event.Entity.Mob.Player.PlayerMoveEvent;

public class PlayerMoveListener extends AbstractEventListener<PlayerMoveEvent> {
    private final Player player;

    public PlayerMoveListener(Player player) {
        this.player = player;
    }

    @Override
    public void handleEvent(PlayerMoveEvent event) {
        player.setPlayerMovementPosition(event.playerMovementPosition());
    }
}
