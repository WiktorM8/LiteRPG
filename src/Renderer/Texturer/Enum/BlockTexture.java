package Renderer.Texturer.Enum;

public enum BlockTexture {
    SKY("/block/sky"),
    WATER("/block/water"),
    GRASS("/block/grass"),
    WHEAT("/block/wheat"),
    PATH("/block/path"),
    STONE_WALL("/block/stone_wall");

    private final String texturePath;

    BlockTexture(String texturePath) {
        this.texturePath = texturePath;
    }

    public int getId() {
        return ordinal();
    }

    public String getTexturePath() {
        return texturePath;
    }
}
