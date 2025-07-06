package Game.ScalingSystem.Entity.Mob.Enemy;

import Game.ScalingSystem.Entity.Mob.LevelInfo;

import java.util.ArrayList;

public abstract class BaseLevelScaling {
    private ArrayList<LevelInfo> levelInfos;

    public BaseLevelScaling() {
        this.levelInfos = new ArrayList<>();

        registerInfo();
    }
    public void setLevelInfos(ArrayList<LevelInfo> levelInfos) {
        this.levelInfos = levelInfos;
    }
    public void addLevelInfo(LevelInfo levelInfo) {
        this.levelInfos.add(levelInfo);
    }
    public ArrayList<LevelInfo> getLevelInfos() {
        return levelInfos;
    }
    public LevelInfo getLevelInfo(int level) {
        if (level < 1) return levelInfos.getFirst();
        if (level > levelInfos.size()) return levelInfos.getLast();
        return levelInfos.get(level - 1);
    }

    /**
     * Registers the level scaling information for the enemy mob.
     */
    public abstract void registerInfo();
}
