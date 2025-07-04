package Game.World.Enum;

import Game.World.Model.WorldVariations;

public enum WorldType {
    SUNNY_FIELDS(
            "Sunny Fields",
            "A bright and cheerful world filled with beautiful wheat fields.",
            new WorldVariations(new String[] {
                    "/sunny_fields/world_0",
                    "/sunny_fields/world_1",
            })
    );

    private final String name;
    private final String description;
    private final WorldVariations variations;

    WorldType(String name, String description, WorldVariations variations) {
        this.name = name;
        this.description = description;
        this.variations = variations;
    }

    public int getId() {
        return ordinal();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public WorldVariations getVariations() {
        return variations;
    }
}
