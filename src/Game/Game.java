package Game;

import Entity.Player;
import Game.World.BaseWorld;
import Game.World.Position;
import Game.World.SunnyFields;
import Logger.ErrorLogger;
import Renderer.RenderSystem;

import java.awt.*;

public class Game implements Runnable {
    private final Thread gameThread; // Thread for the game loop
    private final GameManager gameManager;

    private boolean running = false; // Flag to control the game loop

    // Game state variables
    private BaseWorld world; // The game world
    private Player player; // The player entity

    // Game settings
    private final int SECOND_IN_NANOSECONDS = 1_000_000_000; // 1 second in nanoseconds
    private final double FPS_CAP = 60; // Frames per second cap
    private final double FRAME_TIME = SECOND_IN_NANOSECONDS / FPS_CAP; // Time per frame in nanoseconds

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;
        gameThread = new Thread(this);
        running = true;
        gameThread.start();
        player = new Player(); // Initialize the player entity
        world = new SunnyFields(player); // Initialize the game world
    }

    private void update() {
        player.update();
    }

    private void render() {
        gameManager.requestRender();
    }

    /**
     * @param position Position to which the player will move.
     */
    public void setPlayerMovementPosition(Position position) {
        if (player != null) {
            player.setPlayerMovementPosition(position);
        }
    }

    /**
     * Should not be called outside the Game class.
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

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
    public void setWorld(BaseWorld world) {
        this.world = world;
    }
    public BaseWorld getWorld() {
        return world;
    }
}
