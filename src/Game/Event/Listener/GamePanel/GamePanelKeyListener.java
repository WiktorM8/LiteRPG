package Game.Event.Listener.GamePanel;

import Framework.Event.Dispatcher.AbstractEventDispatcher;
import Framework.Event.Dispatcher.EventBus;
import Framework.Event.EventInterface;
import Game.Camera.WorldCamera;
import Game.Event.Event.Entity.Mob.Player.PlayerMoveEvent;
import Game.GameManager;
import Game.World.Model.Position;

import java.awt.event.*;

public class GamePanelKeyListener extends AbstractEventDispatcher implements KeyListener, MouseListener {
    private final GameManager gameManager;

    private final int tileSize;
    private final int tileCenterOffset;

    public GamePanelKeyListener(GameManager gameManager) {
        this.gameManager = gameManager;
        tileSize = gameManager.tileSize;
        tileCenterOffset = tileSize / 2;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Handle pressed key events
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            WorldCamera camera = gameManager.getGame().getCamera();

            int pixelX = e.getX() - tileCenterOffset;
            int pixelY = e.getY() - tileCenterOffset;
            int playerX = (int) camera.getPosition().getX() + pixelX;
            int playerY = (int) camera.getPosition().getY() + pixelY;

            Position position = new Position(playerX, playerY);
            EventBus.dispatch(new PlayerMoveEvent(position));
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            // Handle left mouse button click
            // For example, you might want to select a tile or interact with an object
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
