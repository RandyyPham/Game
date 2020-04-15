import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class handles keyboard input for the game
 * 
 * @author Randy Pham
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        // loop through entire game object list
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                // key events for the player

                if (key == KeyEvent.VK_W) {
                    tempObject.setDeltaY(-5);
                }

                if (key == KeyEvent.VK_A) {
                    tempObject.setDeltaX(-5);
                }

                if (key == KeyEvent.VK_S) {
                    tempObject.setDeltaY(5);
                }

                if (key == KeyEvent.VK_D) {
                    tempObject.setDeltaX(5);
                }
            }
        }

        // you can press the esc key to exit
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                // key events for the player

                if (key == KeyEvent.VK_W) {
                    tempObject.setDeltaY(0);
                }

                if (key == KeyEvent.VK_A) {
                    tempObject.setDeltaX(0);
                }

                if (key == KeyEvent.VK_S) {
                    tempObject.setDeltaY(0);
                }

                if (key == KeyEvent.VK_D) {
                    tempObject.setDeltaX(0);
                }
            }
        }
    }
}