package Game.World.Enum;

public enum SolidType {
    SOLID("SOLID"),
    NOT_SOLID("NOT_SOLID"),
    WATER("WATER"),
    HIDING("HIDING");

    private final String value;

    SolidType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static SolidType fromString(String solid) {
        return switch (solid.toUpperCase()) {
            case "SOLID" -> SOLID;
            case "NOT_SOLID" -> NOT_SOLID;
            case "HIDING" -> HIDING;
            default -> throw new IllegalArgumentException("Invalid solid type: " + solid);
        };
    }
}
