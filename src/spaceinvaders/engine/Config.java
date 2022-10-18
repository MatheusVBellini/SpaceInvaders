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
        this.args = args;

        // defining frame rate
        this.frameRate = frameRate;
        this.frameTime = 1000 / frameRate;

        // defining graphical mode
        Iterator<String> it = args.iterator();
        while (it.hasNext()) {
            if (it.next().equals("-t") || it.next().equals("--tui")) {
                gameGraphicOption = gameGraphicOptions.TUI;
            }
        }
    }

    // build arguments
    private ArrayList<String> args = new ArrayList<>();

    // graphical mode option
    private enum gameGraphicOptions {GUI, TUI};
    private gameGraphicOptions gameGraphicOption = gameGraphicOptions.GUI;
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
