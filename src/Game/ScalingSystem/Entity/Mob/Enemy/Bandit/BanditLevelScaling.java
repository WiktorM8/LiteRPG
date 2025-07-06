package Game.ScalingSystem.Entity.Mob.Enemy.Bandit;

import Game.ScalingSystem.Entity.Mob.Enemy.BaseLevelScaling;
import Game.ScalingSystem.Entity.Mob.LevelInfo;

public class BanditLevelScaling extends BaseLevelScaling {
    @Override
    public void registerInfo() {
        addLevelInfo(new LevelInfo(1, 5, 50, 3));
        addLevelInfo(new LevelInfo(2, 6, 50, 3));
        addLevelInfo(new LevelInfo(3, 6, 55, 3));
        addLevelInfo(new LevelInfo(4, 6, 60, 3));
        addLevelInfo(new LevelInfo(5, 7, 70, 3));
        addLevelInfo(new LevelInfo(6, 7, 75, 3));
        addLevelInfo(new LevelInfo(7, 7, 80, 3));
        addLevelInfo(new LevelInfo(8, 8, 80, 3));
        addLevelInfo(new LevelInfo(9, 8, 85, 3));
        addLevelInfo(new LevelInfo(10, 9, 90, 3));
    }
}
