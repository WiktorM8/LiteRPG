package Game.World.Model;

public class WorldVariations {
    private final String[] paths;

    public WorldVariations(String[] paths) {
        this.paths = paths;
    }

    public String[] getPaths() {
        return paths;
    }

    public int getVariationCount() {
        return paths.length;
    }
}
