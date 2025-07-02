package Screen.Panel;

import Game.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private final GameManager gameManager;

    public GamePanel(GameManager gameManager) {
        this.gameManager = gameManager;

        // Set the preferred size of the panel based on the game dimensions
        setPreferredSize(new Dimension(gameManager.gameWidth, gameManager.gameHeight));
        // Set the background color of the panel
        setBackground(Color.BLACK);
        // Enable double buffering for smoother rendering
        setDoubleBuffered(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        gameManager.render(g2d); // Render the game using the GameManager
    }
}
