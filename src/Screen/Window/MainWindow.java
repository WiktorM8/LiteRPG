package Screen.Window;

import Game.GameManager;

import javax.swing.*;

public class MainWindow {
    private final JFrame window;

    public MainWindow(GameManager gameManager) {
        window = new JFrame();
        // Set the default close operation to exit the application when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Prevent the window from being resized
        window.setResizable(false);
        window.setSize(gameManager.gameWidth, gameManager.gameHeight + 20);
        // Don't specify a location of the window center
        window.setLocationRelativeTo(null);
        window.setTitle("Lite RPG");
    }

    public void display() {
        window.setVisible(true);
    }

    public JFrame getWindow() {
        return window;
    }

    public void addPanel(JPanel panel) {
        window.getContentPane().removeAll();
        // Add the specified panel to the window
        window.add(panel);
        // Refresh the window to show the new panel
        window.revalidate();
        window.repaint();
    }
}
