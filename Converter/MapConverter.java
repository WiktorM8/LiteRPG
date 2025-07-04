import Game.World.Enum.BlockType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MapConverter {
    private static final Map<Integer, Integer> COLOR_TO_BLOCK_ID = new HashMap<>();

    static {
        for (BlockType block : BlockType.values()) {
            Color color = block.getColor().toAWTColor();
            COLOR_TO_BLOCK_ID.put(color.getRGB(), block.getId());
        }
    }

    public static void main(String[] args) throws IOException {
        File input = new File("Converter/map.png");
        BufferedImage image = ImageIO.read(input);

        int width = image.getWidth();
        int height = image.getHeight();

        List<Integer> mapData = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int blockId = COLOR_TO_BLOCK_ID.getOrDefault(rgb, 0);
                mapData.add(blockId);
            }
        }

        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"dimensions\": {\n");
        json.append("    \"width\": ").append(width).append(",\n");
        json.append("    \"height\": ").append(height).append("\n");
        json.append("  },\n");
        json.append("  \"spawn\": {\n");
        json.append("    \"x\": ").append(width / 2).append(",\n");
        json.append("    \"y\": ").append(height / 2).append("\n");
        json.append("  },\n");
        json.append("  \"map\": [\n");

        for (int i = 0; i < mapData.size(); i++) {
            json.append(mapData.get(i));
            if (i < mapData.size() - 1) json.append(",");
            if ((i + 1) % width == 0) json.append("\n");
        }

        json.append("  ]\n");
        json.append("}\n");

        FileWriter writer = new FileWriter("Converter/map.json");
        writer.write(json.toString());
        writer.close();

        System.out.println("Map saved to Converter/map.json");
    }
}
