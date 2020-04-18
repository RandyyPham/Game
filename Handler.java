import java.awt.Graphics;
import java.util.LinkedList;

/**
 * This class will handle and render all of the objects in the game
 * 
 * @author Randy Pham
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    /**
     * This method updates all GameObjects each time tick() is called
     */
    public void tick() {
        // loop through entire GameObject list
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    /**
     * This method renders all GameObjects
     * 
     * @param graphics - the Graphics object to render for each GameObject
     */
    public void render(Graphics graphics) {
        // loop through entire GameObject list
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(graphics);
        }
    }

    /**
     * This method adds a GameObject object to the LinkedList
     * 
     * @param object - the GameObject to be added
     */
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    /**
     * This method removes a GameObject object from the LinkedList
     * 
     * @param object - the GameObject to be removed
     */
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}