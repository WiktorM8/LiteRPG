package Game.Entity.Mob.Enemy;

import Game.ScalingSystem.Entity.Mob.Enemy.Bandit.BanditLevelScaling;
import Game.ScalingSystem.Entity.Mob.LevelInfo;
import Game.World.BaseWorld;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;

public class Bandit extends EnemyMob {
    public Bandit(BaseWorld world, Position position, int level) {
        this(world, position, level, new BanditLevelScaling().getLevelInfo(level));
    }

    private Bandit(BaseWorld world, Position position, int level, LevelInfo info) {
        super(MobType.BANDIT, world, position,
                level, info.getStrength(), info.getHealth(), info.getSpeed(),
                info.getViewingDistance()
        );
    }
}
