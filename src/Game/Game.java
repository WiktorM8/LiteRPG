package Game;

import Logger.ErrorLogger;

public class Game implements Runnable {
    private final Thread gameThread; // Thread for the game loop
    private boolean running = false; // Flag to control the game loop
    private final GameManager gameManager;

    // Game settings
    private final int SECOND_IN_NANOSECONDS = 1_000_000_000; // 1 second in nanoseconds
    private final double FPS_CAP = 60; // Frames per second cap
    private final double FRAME_TIME = SECOND_IN_NANOSECONDS / FPS_CAP; // Time per frame in nanoseconds

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;
        gameThread = new Thread(this);
        running = true;
        gameThread.start();
    }

    private void update() {
        // Update game logic here
        // This method can be called from the game loop to update the game state
    }

    private void render() {
        gameManager.updateGameView();
    }

    /**
     * Should not be called outside the GameManager class.
     */
    @Override
    public void run() {
        long previousTime = System.nanoTime();
        double delta = 0;

        while (running) {
            try {
                long currentTime = System.nanoTime();
                delta += (currentTime - previousTime) / FRAME_TIME;
                previousTime = currentTime;

                while (delta >= 1) {
                    delta--;
                    update();
                    render();
                }

                Thread.sleep(1); // To prevent excessive CPU usage
            } catch (InterruptedException e) {
                ErrorLogger logger = new ErrorLogger();
                logger.logError("Game thread interrupted", e);
            }
        }
    }
}
