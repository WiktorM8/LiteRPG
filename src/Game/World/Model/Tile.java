package Game.World.Model;

import Game.World.Enum.BlockType;

public class Tile {
    private BlockType blockType;

    public Tile(BlockType blockType) {
        this.blockType = blockType;
    }

    public BlockType getBlockType() {
        return blockType;
    }
}
