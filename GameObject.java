import java.awt.Graphics;

/**
 * This class represents an object in-game
 * 
 * @author Randy Pham
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    /**
     * deltaX represents the change in the x direction of a GameObject
     */
    protected int deltaX;
    /**
     * deltaY represents the change in the y direction of a GameObject
     */
    protected int deltaY;

    protected ID id;

    /**
     * This GameObject constructor creates a GameObject object with values x, y, and
     * their id
     * 
     * @param x  - their x value
     * @param y  - their y value
     * @param id - what type of GameObject it is
     */
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    /**
     * Sets the x value to the preferred x value
     * 
     * @param x - the preferred x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y value to the preferred y value
     * 
     * @param y - the preferred y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the delta x value to the preferred delta x value
     * 
     * @param deltaX - the preferred change in the x direction
     */
    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    /**
     * Sets the delta y value to the preferred delta y value
     * 
     * @param deltaY - the preferred change in the y direction
     */
    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    /**
     * Sets the id value to the preferred id value
     * 
     * @param id - the preferred id value
     */
    public void setID(ID id) {
        this.id = id;
    }

    /**
     * Gets the x value from the object
     * 
     * @return the x value of the object
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y value from the object
     * 
     * @return the y value of the object
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the delta x value from the object
     * 
     * @return the change in the x direction
     */
    public int getDeltaX() {
        return deltaX;
    }

    /**
     * Gets the delta y value from the object
     * 
     * @return the change in the y direction
     */
    public int getDeltaY() {
        return deltaY;
    }

    /**
     * Gets the id value from the object
     * 
     * @return the ID of the object
     */
    public ID getID() {
        return id;
    }
}