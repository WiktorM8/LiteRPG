package Renderer.Texturer.Enum;

public enum EntityTexture {
    PLAYER_STANDING(0, "/entity/player/standing"),
    PLAYER_WALKING_DOWN(1,"/entity/player/walking_down"),
    PLAYER_WALKING_UP(2,"/entity/player/walking_up"),
    PLAYER_WALKING_LEFT(3,"/entity/player/walking_left"),
    PLAYER_WALKING_RIGHT(4,"/entity/player/walking_right");

    private final int id;
    private final String texturePath;

    EntityTexture(int id, String texturePath) {
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
