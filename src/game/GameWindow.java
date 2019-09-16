package game;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas = new GameCanvas();

    public GameWindow() {
        this.setResizable(false);
        this.setSize(384, 600);
        this.setContentPane(this.canvas);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            this.canvas.run();
            this.canvas.repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public void gameLoop() {
//        long lastTime = 0;
//        while (true) {
//            long currentTime = System.nanoTime();
//            if (currentTime - lastTime >= 17_000_000) {
//                this.canvas.run();
//                this.canvas.repaint();
//                lastTime = currentTime;
//            }
//        }
//    }
}
