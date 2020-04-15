import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a Player object that the user controls
 * 
 * @author Randy Pham
 */
public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        x += deltaX;
        y += deltaY;

        x = Game.contain(x, 0, Game.WIDTH - 38);
        y = Game.contain(y, 0, Game.HEIGHT - 61);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 32, 32);
    }
}