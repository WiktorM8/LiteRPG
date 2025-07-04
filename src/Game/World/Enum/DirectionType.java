package Game.World.Enum;

public enum DirectionType {
    NONE("NONE"),
    UP("UP"),
    DOWN("DOWN"),
    LEFT("LEFT"),
    RIGHT("RIGHT");

    public final String value;

    private DirectionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DirectionType fromString(String direction) {
        return switch (direction.toUpperCase()) {
            case "NONE" -> NONE;
            case "UP" -> UP;
            case "DOWN" -> DOWN;
            case "LEFT" -> LEFT;
            case "RIGHT" -> RIGHT;
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
        };
    }
}
