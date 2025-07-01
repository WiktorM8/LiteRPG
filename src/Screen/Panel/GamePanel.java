package Screen.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    // Tile settings
    private final int baseTileSize = 16; // Base tile size in pixels
    private final int scaleFactor = 3; // Scale factor for the tile size
    private final int tileSize = baseTileSize * scaleFactor; // Tile size in pixels

    // Game view settings
    private final int gameTileWidth = 16; // Number of tiles in width
    private final int gameTileHeight = 12; // Number of tiles in height
    private final int gameWidth = gameTileWidth * tileSize; // Game width in pixels
    private final int gameHeight = gameTileHeight * tileSize; // Game height in pixels

    Thread gameThread; // Thread for the game loop

    public GamePanel() {
        // Set the preferred size of the panel based on the game dimensions
        setPreferredSize(new Dimension(gameWidth, gameHeight));
        // Set the background color of the panel
        setBackground(Color.BLACK);
        // Enable double buffering for smoother rendering
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
    }
}
