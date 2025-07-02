package Renderer.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {

    public static BufferedImage scaleImage(BufferedImage original, int scaleFactor) {
        int newWidth = original.getWidth() * scaleFactor;
        int newHeight = original.getHeight() * scaleFactor;

        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g2d = scaledImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2d.drawImage(original, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }
}
