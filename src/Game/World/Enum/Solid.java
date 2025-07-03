package Game.World.Enum;

public enum Solid {
    SOLID("SOLID"),
    NOT_SOLID("NOT_SOLID"),
    HIDING("HIDING");

    private final String value;

    Solid(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Solid fromString(String solid) {
        return switch (solid.toUpperCase()) {
            case "SOLID" -> SOLID;
            case "NOT_SOLID" -> NOT_SOLID;
            case "HIDING" -> HIDING;
            default -> throw new IllegalArgumentException("Invalid solid type: " + solid);
        };
    }
}
