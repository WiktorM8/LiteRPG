package Renderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class AnimatedTexture {
    private BufferedImage[] frames;
    private int frameCount;
    private int frameTime;
    private boolean loop;

    public AnimatedTexture(String texturePath, String configPath) {
        try {
            JSONObject config = new JSONObject(new String(Files.readAllBytes(Paths.get(configPath))));
            frameCount = config.getInt("frame_count");
            frameTime = config.getInt("frame_time");
            loop = config.optBoolean("loop", true);

            BufferedImage fullImage = ImageIO.read(new File(texturePath));
            int frameWidth = fullImage.getWidth();
            int frameHeight = fullImage.getHeight() / frameCount;

            frames = new BufferedImage[frameCount];
            for (int i = 0; i < frameCount; i++) {
                frames[i] = fullImage.getSubimage(0, i * frameHeight, frameWidth, frameHeight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public AnimatedTexture(String textureName) {
        this("assets/textures/" + textureName + ".png", "assets/textures/" + textureName + ".json");
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
