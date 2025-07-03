package Game.World.Enum;

public enum Block {
    SKY(0, "SKY", "Sky", Solid.SOLID, "/block/sky.png"),
    WATER(1, "WATER", "Water", Solid.SOLID, "/block/water.png"),
    GRASS(2, "GRASS", "Grass", Solid.NOT_SOLID, "/block/grass.png"),
    WHEAT(3, "WHEAT", "Wheat", Solid.HIDING, "/block/wheat.png"),
    STONE_PATH(4, "STONE_PATH", "Stone Path",  Solid.NOT_SOLID, "/block/stone_path.png"),
    STONE_WALL(5, "STONE_WALL", "Stone Wall", Solid.SOLID, "/block/stone_wall.png");

    private final int id;
    private final String type;
    private final String name;
    private final String texture;
    private final Solid solid;

    private Block(int id, String type, String name, Solid solid, String texture) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.texture = texture;
        this.solid = solid;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return texture;
    }

    public Solid getSolid() {
        return solid;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id:'" + id + '\'' +
                ", type:'" + type + '\'' +
                ", name:" + name +
                ", texture:'" + texture + '\'' +
                '}';
    }
}
