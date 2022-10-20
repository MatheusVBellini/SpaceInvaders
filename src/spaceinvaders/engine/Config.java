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

        // defining graphical mode
        Iterator<String> it = args.iterator();
        while (it.hasNext()) {
            if (it.next().equals("-g") || it.next().equals("--gui")) {
                gameGraphicOption = gameGraphicOptions.GUI;
            }
        }
    }

    // build arguments
    private ArrayList<String> args;

    // graphical mode option
    private enum gameGraphicOptions {GUI, TUI};
    private gameGraphicOptions gameGraphicOption = gameGraphicOptions.TUI;
    public boolean getGameGraphicOption() {
        return (this.gameGraphicOption == gameGraphicOptions.TUI) ? true : false; // true == TUI | false == GUI
    }

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
