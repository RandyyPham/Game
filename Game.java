import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * This is the main program of the game
 * 
 * @author Randy Pham
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -1442798787354930462L;

    private Thread thread;
    private boolean running = false;

    private Handler handler;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    /**
     * This constructor makes a new window of the game
     */
    public Game() {
        new Window(WIDTH, HEIGHT, "Title", this);

        handler = new Handler();
    }

    /**
     * Start method
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Stop method
     */
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The game loop
     */
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    /**
     * Render method. What is actually viewable from the window
     */
    private void render() {
        BufferStrategy bufferedStrategy = this.getBufferStrategy();
        if (bufferedStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferedStrategy.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(graphics);

        graphics.dispose();
        bufferedStrategy.show();
    }

    /**
     * Tick method
     */
    private void tick() {
        handler.tick();
    }

    public static void main(String[] args) {
        new Game();
    }
}