package Game.Entity.Mob.Enemy;

import Game.Entity.Mob.Mob;
import Game.Entity.Mob.Player;
import Game.World.BaseWorld;
import Game.World.Enum.Entity.MobType;
import Game.World.Model.Position;

public abstract class EnemyMob extends Mob {
    private double viewingDistance;

    public EnemyMob(
            MobType mobType,
            BaseWorld world, Position position,
            int level,
            double strength, double health, double speed,
            double viewingDistance
    ) {
        super(mobType, world, position, level, strength, health, speed);
        this.viewingDistance = viewingDistance * world.getGameManager().tileSize;
    }

    public void setViewingDistance(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Viewing distance cannot be negative.");
        }
        this.viewingDistance = distance;
    }
    public double getViewingDistance() {
        return viewingDistance;
    }

    public void move() {
        Player player = world.getPlayer();

        if (getDistanceToPlayer() > viewingDistance) {
            return;
        }
        Position playerPosition = player.getPosition();
        Position position = this.getPosition();
        double deltaX = playerPosition.getX() - position.getX();
        double deltaY = playerPosition.getY() - position.getY();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        if (distance == 0) {
            return;
        }
        double moveX = (deltaX / distance) * speed;
        double moveY = (deltaY / distance) * speed;
        Position newPosition = new Position(
                position.getX() + moveX,
                position.getY() + moveY
        );
        this.setPosition(newPosition);
    }

    @Override
    public void update() {
        move();
    }

    public double getDistanceToPlayer() {
        Position playerPosition = world.getPlayer().getPosition();
        Position position = this.getPosition();

        double distanceX = Math.abs(playerPosition.getX() - position.getX());
        double distanceY = Math.abs(playerPosition.getY() - position.getY());

        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
}
