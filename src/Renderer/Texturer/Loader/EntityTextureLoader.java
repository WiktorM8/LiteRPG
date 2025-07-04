package Renderer.Texturer.Loader;

import Renderer.AnimatedTexture;
import Renderer.Texturer.Enum.EntityTexture;

import java.util.HashMap;
import java.util.Map;

public class EntityTextureLoader {
    public static Map<EntityTexture, AnimatedTexture> loadTextures() {
        Map<EntityTexture, AnimatedTexture> textures = new HashMap<>();

        for (EntityTexture texture : EntityTexture.values()) {
            textures.put(texture, new AnimatedTexture(texture.getTexturePath()));
        }

        return textures;
    }
}
