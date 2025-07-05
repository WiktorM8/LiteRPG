package Screen.Panel;

import Game.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private final GameManager gameManager;

    public MainMenuPanel(GameManager gameManager) {
        this.gameManager = gameManager;

        setPreferredSize(new Dimension(gameManager.gameWidth, gameManager.gameHeight));
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("LiteRPG");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(80));
        add(titleLabel);
        add(Box.createVerticalStrut(60));

        add(createButton("Start Game", e -> startGame()));
        add(Box.createVerticalStrut(20));
        add(createButton("Load Game", e -> loadGame()));
        add(Box.createVerticalStrut(20));
        add(createButton("Settings", e -> openSettings()));
        add(Box.createVerticalStrut(20));
        add(createButton("Exit", e -> exitGame()));
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));
        button.setFont(new Font("SansSerif", Font.PLAIN, 20));
        button.addActionListener(action);
        return button;
    }

    private void startGame() {
        gameManager.startGame();
    }

    private void loadGame() {
        /**
         * @Todo Implement loading game functionality
         */
        System.out.println("Load Game clicked");
    }

    private void openSettings() {
        /**
         * @Todo Implement settings functionality
         */
        System.out.println("Settings clicked");
    }

    private void exitGame() {
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
