package Game;

import Game.Camera.WorldCamera;
import Game.Entity.Mob.Enemy.Bandit;
import Game.Entity.Mob.Player;
import Game.World.BaseWorld;
import Game.World.Enum.WorldType;
import Game.World.Loader.WorldLoader;
import Logger.ErrorLogger;

public class Game implements Runnable {
    private final Thread gameThread; // Thread for the game loop
    private final GameManager gameManager;

    private boolean running = false; // Flag to control the game loop

    // Game state variables
    private BaseWorld world; // The game world
    private WorldCamera camera; // The camera for the game world
    private Player player; // The player entity

    // Game settings
    private final int SECOND_IN_NANOSECONDS = 1_000_000_000; // 1 second in nanoseconds
    private final double FPS_CAP = 60; // Frames per second cap
    private final double FRAME_TIME = SECOND_IN_NANOSECONDS / FPS_CAP; // Time per frame in nanoseconds

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;
        gameThread = new Thread(this);
        running = true;
        player = new Player(gameManager, world); // Initialize the player entity
        world = WorldLoader.loadWorld(WorldType.SUNNY_FIELDS, 1, player, gameManager);
        camera = new WorldCamera(gameManager);
        gameThread.start();
    }

    private void update() {
        world.update();
        player.update();
        camera.focusEntity(player);

    }

    private void render() {
        gameManager.requestRender();
    }

    /**
     * Should not be called outside the Game class.
     */
    @Override
    public void run() {
        long previousTime = System.nanoTime();
        double delta = 0;
        int fps = 0;
        long timer = System.currentTimeMillis();

        camera.focusEntity(player);

        while (running) {
            try {
                long currentTime = System.nanoTime();
                delta += (currentTime - previousTime) / FRAME_TIME;
                previousTime = currentTime;

                while (delta >= 1) {
                    delta--;
                    update();
                    render();
                    fps++;
                }

                if (System.currentTimeMillis() - timer >= 1000) {
                    System.out.println("FPS: " + fps);
                    fps = 0;
                    timer += 1000;
                }

                Thread.sleep(1); // To prevent excessive CPU usage
            } catch (Exception e) {
                ErrorLogger.log("Game loop error", e);
                running = false; // Stop the game loop on error
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
    public void setCamera(WorldCamera camera) {
        this.camera = camera;
    }
    public WorldCamera getCamera() {
        return camera;
    }
}
