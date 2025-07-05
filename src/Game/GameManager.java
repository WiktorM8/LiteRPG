package Game;

import Game.Entity.Mob.Player;
import Game.Event.Listener.GamePanel.GamePanelKeyListener;
import Game.World.Model.Position;
import Renderer.Entity.PlayerRenderer;
import Renderer.RenderSystem;
import Screen.Window.MainWindow;
import Screen.Panel.GamePanel;

import java.awt.*;

public final class GameManager {
    private MainWindow mainWindow;
    private GamePanel gamePanel;
    private Game game;
    private GamePanelKeyListener gamePanelKeyListener;
    private RenderSystem renderSystem;

    // Tile settings
    public final int baseTileSize = 16; // Base tile size in pixels
    public final int scaleFactor = 3; // Scale factor for the tile size
    public final int tileSize = baseTileSize * scaleFactor; // Tile size in pixels

    // Game view settings
    public final int gameTileWidth = 22; // Number of tiles in width
    public final int gameTileHeight = 16; // Number of tiles in height
    public final int gameWidth = gameTileWidth * tileSize; // Game width in pixels
    public final int gameHeight = gameTileHeight * tileSize;// Game height in pixels

    public GameManager() {
        mainWindow = new MainWindow(this);
        mainWindow.display();
        gamePanelKeyListener = new GamePanelKeyListener(this);
        renderSystem = getRenderSystem();
    }

    public RenderSystem getRenderSystem() {
        RenderSystem renderSystem = new RenderSystem(tileSize, scaleFactor);
        PlayerRenderer playerRenderer = new PlayerRenderer(renderSystem);
        renderSystem.registerRenderer(Player.class, playerRenderer);

        return renderSystem;
    }

    public void startGame() {
        // Initialize the game panel
        gamePanel = new GamePanel(this);
        gamePanel.setFocusable(true); // Make the game panel focusable to receive key events
        gamePanel.addKeyListener(gamePanelKeyListener);
        gamePanel.addMouseListener(gamePanelKeyListener);
        // Add the game panel to the main window
        mainWindow.addPanel(gamePanel);
        // Initialize the game
        game = new Game(this);
    }

    public void requestRender() {
        // Update the game view here
        // This method can be called from the game loop to update the game panel
        if (gamePanel != null) {
            gamePanel.repaint(); // Repaint the game panel to reflect changes
        }
    }

    public void render(Graphics2D g2d) {
        if (game == null) {
            return; // Ensure the game and player are initialized before rendering
        }
        renderSystem.render(g2d, game.getWorld());
        renderSystem.render(g2d, game.getPlayer());
        renderSystem.renderGUI(g2d, this);
    }

    public Game getGame() {
        return game;
    }

}
