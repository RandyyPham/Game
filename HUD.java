import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 100;

    private Handler handler;

    public HUD(Handler handler) {
        this.handler = handler;
    }

    public void tick() {
        HEALTH = Game.contain(HEALTH, 0, 100);
    }

    public void render(Graphics graphics) {
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                graphics.setColor(Color.darkGray);
                graphics.fillRect(tempObject.getX() - 32, tempObject.getY() - 24, 100, 16);

                graphics.setColor(Color.green);
                graphics.fillRect(tempObject.getX() - 32, tempObject.getY() - 24, HEALTH, 16);

                graphics.setColor(Color.white);
                graphics.drawRect(tempObject.getX() - 32, tempObject.getY() - 24, 100, 16);
            }
        }
    }
}