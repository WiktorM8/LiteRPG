package Renderer.Texturer.Enum;

public enum EntityTexture {
    PLAYER_STANDING("/entity/player/standing"),
    PLAYER_WALKING_DOWN("/entity/player/walking_down"),
    PLAYER_WALKING_UP("/entity/player/walking_up"),
    PLAYER_WALKING_LEFT("/entity/player/walking_left"),
    PLAYER_WALKING_RIGHT("/entity/player/walking_right"),
    BANDIT_STANDING("/entity/bandit/standing");

    private final String texturePath;

    EntityTexture(String texturePath) {
        this.texturePath = texturePath;
    }

    public int getId() {
        return ordinal();
    }

    public String getTexturePath() {
        return texturePath;
    }
}
