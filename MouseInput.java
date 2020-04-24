import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class handles mouse input for the game
 * 
 * @author Randy Pham
 */
public class MouseInput extends MouseAdapter {

    private Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }

    public void mousePressed(MouseEvent event) {
        int button = event.getButton();
        int mouseX = event.getX();
        int mouseY = event.getY();

        // right click
        if (button == MouseEvent.BUTTON3) {

            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);

                if (tempObject.getID() == ID.Player) {
                    // reset the speeds
                    tempObject.setDeltaX(0);
                    tempObject.setDeltaY(0);

                    int playerX = tempObject.getX();
                    int playerY = tempObject.getY();

                    // the length of the journey
                    double xDifference = Math.abs(mouseX) - Math.abs(playerX);
                    double yDifference = Math.abs(mouseY) - Math.abs(playerY);

                    double slope = (yDifference / xDifference);

                    System.out.println("\nHere are the player coords: x: " + playerX + " y: " + playerY);
                    System.out.println("Here are the destination coords: x: " + mouseX + " y: " + mouseY);

                    System.out.println("\n--------------------------------------------------\n");

                    System.out.println("Here are the differences: x: " + xDifference + " y: " + yDifference);
                    System.out.println("Here is the slope: (y2 - y1 / x2 - x1) " + slope);

                    


                    //double distance = Math.hypot(xDifference, yDifference);

                    // the direction of the journey
                    //double xDirection = xDifference / distance;
                    //double yDirection = yDifference / distance;

                    // we want the player to move towards where right click was pressed and stop
                    // there


                }
            }
        }
    }
}