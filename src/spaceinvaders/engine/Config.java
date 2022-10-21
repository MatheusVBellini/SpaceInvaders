package spaceinvaders.engine;

// extern imports
import java.util.ArrayList;
import java.util.Iterator;

public class Config {
    /*
     *
     * Game Specs
     *
     */
    // constructor
    public Config(long frameRate, ArrayList<String> args) {
        this.args = new ArrayList<String>(args);

        // defining frame rate
        this.frameRate = frameRate;
        this.frameTime = 1000 / frameRate;

        // reading args from terminal
        Iterator<String> it = args.iterator();
        while (it.hasNext()) {}
    }

    // build arguments
    private ArrayList<String> args;
    
    // frame rate
    private long frameRate;
    private long frameTime;
    public long getFrameRate() {
        return frameRate;
    }
    public long getFrameTime() {
        return frameTime;
    }
}
