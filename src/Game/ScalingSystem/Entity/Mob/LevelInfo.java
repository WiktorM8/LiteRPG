package Game.ScalingSystem.Entity.Mob;

public class LevelInfo {
    private final int level;
    private final double strength;
    private final double health;
    private final double speed;

    public LevelInfo(int level, double strength, double health, double speed) {
        this.level = level;
        this.strength = strength;
        this.health = health;
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public double getStrength() {
        return strength;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }
}
