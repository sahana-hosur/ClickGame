import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

class musicthread extends Thread {
    private String filepath;
    private boolean running;
    private boolean paused;
    private Object lock = new Object();

    public musicthread(String filepath) {
        this.filepath = filepath;
        running = true;
        paused = false;
    }

    public void run() {
        try {
            while (running) {
                synchronized (lock) {
                    while (paused) {
                        lock.wait();
                    }
                }
                FileInputStream fis = new FileInputStream(filepath);
                BufferedInputStream bis = new BufferedInputStream(fis);
                Player player = new Player(bis);
                player.play();
            }
        } catch (JavaLayerException | java.io.IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        paused = true;
    }

    public void play() {
        synchronized (lock) {
            paused = false;
            lock.notify();
        }
    }

    public void stopPlayback() {
        running = false;
        interrupt();
    }
}
