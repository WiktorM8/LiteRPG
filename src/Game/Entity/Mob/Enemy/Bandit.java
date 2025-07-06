package Game.Entity.Mob.Enemy;

import Game.Entity.Mob.Player;
import Game.ScalingSystem.Entity.Mob.Enemy.Bandit.BanditLevelScaling;
import Game.ScalingSystem.Entity.Mob.LevelInfo;
import Game.World.BaseWorld;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;

public class Bandit extends EnemyMob {
    private static final int VIEWING_DISTANCE = 8;

    public Bandit(BaseWorld world, Position position, int level) {
        this(world, position, level, new BanditLevelScaling().getLevelInfo(level));
    }

    private Bandit(BaseWorld world, Position position, int level, LevelInfo info) {
        super(MobType.BANDIT, world, position,
                level, info.getStrength(), info.getHealth(), info.getSpeed(),
                VIEWING_DISTANCE
        );
    }
}
