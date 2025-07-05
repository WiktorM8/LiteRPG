package Game.Event.Event.Entity.Mob.Player;

import Framework.Event.EventInterface;
import Game.World.Model.Position;

public record PlayerMoveEvent(Position playerMovementPosition) implements EventInterface {
}
