package Game;

import Screen.MainWindow;
import Screen.Panel.GamePanel;

public final class GameManager {
    private MainWindow mainWindow;
    private GamePanel gamePanel;
    private Game game;


    public GameManager() {
        mainWindow = new MainWindow();
        mainWindow.display();
    }

    public void startGame() {
        // Initialize the game panel
        gamePanel = new GamePanel();
        gamePanel.setFocusable(true); // Make the game panel focusable to receive key events
        // Add the game panel to the main window
        mainWindow.addPanel(gamePanel);
        // Initialize the game
        game = new Game(this);
    }

    public void updateGameView() {
        // Update the game view here
        // This method can be called from the game loop to update the game panel
        if (gamePanel != null) {
            gamePanel.repaint(); // Repaint the game panel to reflect changes
        }
    }


}
