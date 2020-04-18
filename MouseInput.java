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

                    // the length of the journey
                    int xDifference = Math.abs(mouseX) - Math.abs(tempObject.getX());
                    int yDifference = Math.abs(mouseY) - Math.abs(tempObject.getY());

                    double distance = Math.hypot(xDifference, yDifference);

                    // the direction of the journey
                    double xDirection = xDifference / distance;
                    double yDirection = yDifference / distance;

                    //TODO: implement direction and distance of the journey to move the object

                    // we want the player to move towards where right click was pressed and stop
                    // there

                    while (tempObject.getX() != mouseX || tempObject.getY() != mouseY) {
                        // while the player is not where the mouse clicked, move the player there

                        if (tempObject.getX() < mouseX && tempObject.getY() < mouseY) {
                            tempObject.setDeltaX(1);
                            tempObject.setDeltaY(1);

                            if (tempObject.getX() == mouseX) {
                                tempObject.setDeltaX(0);
                            }
                            if (tempObject.getY() == mouseY) {
                                tempObject.setDeltaY(0);
                            }
                        } else if (tempObject.getX() > mouseX && tempObject.getY() > mouseY) {
                            tempObject.setDeltaX(-1);
                            tempObject.setDeltaY(-1);

                            if (tempObject.getX() == mouseX) {
                                tempObject.setDeltaX(0);
                            }
                            if (tempObject.getY() == mouseY) {
                                tempObject.setDeltaY(0);
                            }
                        } else if (tempObject.getX() < mouseX && tempObject.getY() > mouseY) {
                            tempObject.setDeltaX(1);
                            tempObject.setDeltaY(-1);

                            if (tempObject.getX() == mouseX) {
                                tempObject.setDeltaX(0);
                            }
                            if (tempObject.getY() == mouseY) {
                                tempObject.setDeltaY(0);
                            }
                        } else if (tempObject.getX() > mouseX && tempObject.getY() < mouseY) {
                            tempObject.setDeltaX(-1);
                            tempObject.setDeltaY(1);

                            if (tempObject.getX() == mouseX) {
                                tempObject.setDeltaX(0);
                            }
                            if (tempObject.getY() == mouseY) {
                                tempObject.setDeltaY(0);
                            }
                        } else {
                            tempObject.setDeltaX(0);
                        }

                        System.out.println("Player coords: " + tempObject.getX() + " " + tempObject.getY());
                        System.out.println("Destination coords: " + mouseX + " " + mouseY);
                    }

                    tempObject.setDeltaX(0);
                    tempObject.setDeltaY(0);
                }
            }
        }
    }
}