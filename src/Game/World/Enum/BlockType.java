package Game.World.Enum;

import Framework.Misc.Color;
import Renderer.Texturer.Enum.BlockTexture;

public enum BlockType {
    SKY("SKY", "Sky", SolidType.SOLID, BlockTexture.SKY,
            new Color(0, 255, 255)),
    WATER("WATER", "Water", SolidType.WATER, BlockTexture.WATER,
            new Color(0, 0, 128)),
    GRASS("GRASS", "Grass", SolidType.NOT_SOLID, BlockTexture.GRASS,
            new Color(66, 185, 96)),
    WHEAT("WHEAT", "Wheat", SolidType.HIDING, BlockTexture.WHEAT,
            new Color(255, 255, 100)),
    PATH("PATH", "Stone Path",  SolidType.NOT_SOLID, BlockTexture.PATH,
            new Color(171, 108, 64)),
    STONE_WALL( "STONE_WALL", "Stone Wall", SolidType.SOLID, BlockTexture.STONE_WALL,
            new Color(64, 64, 64));

    private final String type;
    private final String name;
    private final BlockTexture texture;
    private final SolidType solid;
    private final Color color;


    BlockType(String type, String name, SolidType solid, BlockTexture texture, Color color) {
        this.type = type;
        this.name = name;
        this.texture = texture;
        this.solid = solid;
        this.color = color;
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

    public BlockTexture getTexture() {
        return texture;
    }

    public SolidType getSolid() {
        return solid;
    }

    public Color getColor() {
        return color;
    }

    public static BlockType getById(int id) {
        for (BlockType block : BlockType.values()) {
            if (block.getId() == id) {
                return block;
            }
        }
        throw new IllegalArgumentException("No block found with id: " + id);
    }

    @Override
    public String toString() {
        return "Block{" +
                "id:'" + getId() + '\'' +
                ", type:'" + type + '\'' +
                ", name:" + name +
                ", texture:'" + texture + '\'' +
                '}';
    }

    public boolean isSolid() {
        return solid == SolidType.SOLID;
    }
    public boolean isWater() {
        return solid == SolidType.WATER;
    }
}
