package Renderer.Texturer.Enum;

public enum BlockTexture {
    SKY(0, "/block/sky"),
    WATER(1, "/block/water"),
    GRASS(2, "/block/grass"),
    WHEAT(3, "/block/wheat"),
    STONE_PATH(4, "/block/stone_path"),
    STONE_WALL(5, "/block/stone_wall");

    private final int id;
    private final String texturePath;

    BlockTexture(int id, String texturePath) {
        this.id = id;
        this.texturePath = texturePath;
    }

    public int getId() {
        return id;
    }

    public String getTexturePath() {
        return texturePath;
    }
}
