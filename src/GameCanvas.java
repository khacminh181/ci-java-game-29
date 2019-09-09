import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;
    int backgroundX;
    int backgroundY;

    Image player;
    int playerX;
    int playerY;

    KeyPressed keyPressed;

    public GameCanvas() {
        this.keyPressed = new KeyPressed();

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

        // background
        this.backgroundX = 0;
        this.backgroundY = 600 - 3109;

        this.setFocusable(true);
        // Bat event bam phim
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    keyPressed.upPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    keyPressed.downPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    keyPressed.rightPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    keyPressed.leftPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    keyPressed.upPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    keyPressed.downPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    keyPressed.rightPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    keyPressed.leftPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        g.drawImage(this.background, this.backgroundX, this.backgroundY, null);
        g.drawImage(this.player, this.playerX, this.playerY, null);
    }


    public void run() {
        System.out.println("game loop");

        // background
        if (this.backgroundY < 0) {
            this.backgroundY += 10;
        } else {
            this.backgroundY = -3109 + 600;
        }

        // player
        if (keyPressed.upPressed) {
           this.playerY -= 5;
        }
        if (keyPressed.downPressed) {
            this.playerY += 5;
        }
        if (keyPressed.rightPressed) {
            this.playerX += 5;
        }
        if (keyPressed.leftPressed) {
            this.playerX -= 5;
        }
    }
}
