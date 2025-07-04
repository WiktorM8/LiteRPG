package Renderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Logger.ErrorLogger;
import Renderer.Utils.ImageUtils;
import org.json.JSONObject;

public class AnimatedTexture {
    private static final String DEFAULT_CONFIG_PATH = "assets/textures/default.json";

    private BufferedImage[] frames;
    private int frameCount;
    private int frameTime;
    private boolean loop;

    public AnimatedTexture(String texturePath, String configPath, int scaleFactor) {
        try {
            JSONObject config;
            Path path = Paths.get(configPath);
            if (Files.exists(path)) {
                config = new JSONObject(new String(Files.readAllBytes(path)));
            } else {
                config = new JSONObject(new String(Files.readAllBytes(Paths.get(DEFAULT_CONFIG_PATH))));
            }

            frameCount = config.getInt("frame_count");
            frameTime = config.getInt("frame_time");
            loop = config.optBoolean("loop", true);

            BufferedImage fullImage = ImageIO.read(new File(texturePath));
            int frameWidth = fullImage.getWidth();
            int frameHeight = fullImage.getHeight() / frameCount;

            frames = new BufferedImage[frameCount];
            for (int i = 0; i < frameCount; i++) {
                BufferedImage subimage = fullImage.getSubimage(0, i * frameHeight, frameWidth, frameHeight);
                frames[i] = ImageUtils.scaleImage(subimage, scaleFactor);
            }
        } catch (IOException e) {
            ErrorLogger.log("Failed to load animated texture: " + texturePath + " with config: " + configPath, e);
        }
    }
    public AnimatedTexture(String textureName, int scaleFactor) {
        this("assets/textures/" + textureName + ".png", "assets/textures/" + textureName + ".json", scaleFactor);
    }

    public BufferedImage getFrame(int index) {
        return frames[index % frames.length];
    }

    public int getFrameTime() {
        return frameTime;
    }

    public int getFrameCount() {
        return frames.length;
    }
}
