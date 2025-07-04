package Game.World.Loader;

import Game.Entity.Mob.Player;
import Game.GameManager;
import Game.World.BaseWorld;
import Game.World.Enum.BlockType;
import Game.World.Enum.WorldType;
import Game.World.Model.Tile;
import Game.World.Model.WorldVariations;
import Game.World.Worlds.SunnyFields;
import Logger.ErrorLogger;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WorldLoader {
    public static BaseWorld loadWorld(WorldType worldType, int index, Player player, GameManager gameManager) {
        WorldVariations variations = worldType.getVariations();

        String worldPath;
        if (index < 0) worldPath = variations.getPaths()[0];
        else if (index >= variations.getVariationCount()) worldPath = variations.getPaths()[variations.getVariationCount() - 1];
        else worldPath = "assets/worlds/" + variations.getPaths()[index] + ".json";

        int width, height, spawnX, spawnY;
        Tile[][] mapData;
        try {
            JSONObject worldData = new JSONObject(new String(Files.readAllBytes(Paths.get(worldPath))));

            JSONObject dimensions = worldData.getJSONObject("dimensions");
            width = dimensions.getInt("width");
            height = dimensions.getInt("height");

            JSONObject spawn = worldData.getJSONObject("spawn");
            spawnX = spawn.getInt("x");
            spawnY = spawn.getInt("y");

            List<Object> rawMap = worldData.getJSONArray("map").toList();

            if (rawMap.size() != width * height) {
                throw new IllegalArgumentException("Map size does not match width*height");
            }

            mapData = new Tile[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int blockId = Integer.parseInt(rawMap.get(y * width + x).toString());
                    BlockType blockType = BlockType.getById(blockId);
                    mapData[y][x] = new Tile(blockType);
                }
            }

        } catch (Exception e) {
            ErrorLogger.log("Failed to load world: " + worldPath, e);
            throw new RuntimeException("Failed to load world: " + worldPath, e);
        }

        BaseWorld world;
        switch (worldType) {
            case SUNNY_FIELDS:
                world = new SunnyFields(gameManager, width, height, spawnX, spawnY, mapData);
                break;
            default:
                throw new IllegalArgumentException("Unsupported world type: " + worldType);
        }

        player.setPosition(spawnX * gameManager.tileSize, spawnY * gameManager.tileSize); // Set player position to spawn point
        player.setPlayerMovementPosition(spawnX * gameManager.tileSize, spawnY * gameManager.tileSize); // Set player position to spawn point
        player.setWorld(world);

        return world;
    }
}
