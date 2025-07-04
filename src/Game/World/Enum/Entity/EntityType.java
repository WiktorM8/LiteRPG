package Game.World.Enum.Entity;

public enum EntityType {
    MOB("MOB", "Mob"),;

    private final String type;
    private final String name;

    EntityType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return ordinal();
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
}
