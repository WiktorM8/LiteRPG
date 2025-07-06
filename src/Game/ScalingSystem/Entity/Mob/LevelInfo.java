package Game.ScalingSystem.Entity.Mob;

public class LevelInfo {
    private final int level;
    private final double strength;
    private final double health;
    private final double speed;
    private final double viewingDistance;

    public LevelInfo(int level, double strength, double health, double speed, double viewingDistance) {
        this.level = level;
        this.strength = strength;
        this.health = health;
        this.speed = speed;
        this.viewingDistance = viewingDistance;
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

    public double getViewingDistance() {
        return viewingDistance;
    }
}
