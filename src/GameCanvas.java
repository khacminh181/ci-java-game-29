import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;

    Image player;
    int playerX;
    int playerY;

    public GameCanvas() {
        // Load image
        try {
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // player
        this.playerX = 175;
        this.playerY = 500;

        this.setFocusable(true);
        // Bat event bam phim
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    playerY--;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        g.drawImage(this.background, 0, 0, null);
        g.drawImage(this.player, this.playerX, this.playerY, null);
    }


    public void run() {
        System.out.println("game loop");
    }
}
