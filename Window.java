import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class holds the window of the game
 */
public class Window extends Canvas {

    private static final long serialVersionUID = -3464197827251618333L;

    JFrame frame;

    /**
     * This Window Constructor creates a window that will play the {@code Game}
     * 
     * @param width  - the preferred width of the window
     * @param height - the preferred height of the window
     * @param title  - the title of the window (Usually the name of the Game)
     * @param game   - the Game that will be played
     */
    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);
        // size of the window
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        // some window settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        // add the components (in this case, the game)
        frame.add(game);
        frame.setVisible(true);
        // start the game
        game.start();
    }
}