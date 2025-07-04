package Renderer.Texturer.Loader;

import Renderer.AnimatedTexture;
import Renderer.Texturer.Enum.BlockTexture;

import java.util.HashMap;
import java.util.Map;

public class BlockTextureLoader {
    public static Map<BlockTexture, AnimatedTexture> loadTextures() {
        Map<BlockTexture, AnimatedTexture> textures = new HashMap<>();

        for (BlockTexture texture : BlockTexture.values()) {
            textures.put(texture, new AnimatedTexture(texture.getTexturePath()));
        }

        return textures;
    }
}
