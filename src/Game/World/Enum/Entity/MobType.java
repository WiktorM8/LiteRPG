package Game.World.Enum.Entity;

import Framework.Misc.Color;
import Renderer.Texturer.Enum.EntityTexture;
import Renderer.Texturer.Model.EntityTextures;

public enum MobType {
    PLAYER("Player", "Player", new EntityTextures(
            EntityTexture.PLAYER_STANDING,
            EntityTexture.PLAYER_WALKING_UP,
            EntityTexture.PLAYER_WALKING_DOWN,
            EntityTexture.PLAYER_WALKING_LEFT,
            EntityTexture.PLAYER_WALKING_RIGHT
    ), new Color(255, 255, 255));

    private final String type;
    private final String name;
    private final EntityTextures texture;
    private final Color color;

    MobType(String type, String name, EntityTextures texture, Color color) {
        this.type = type;
        this.name = name;
        this.texture = texture;
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
    public EntityTextures getTexture() {
        return texture;
    }
    public Color getColor() {
        return color;
    }
}
