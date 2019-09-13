import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Enemy enemy;
    PlayerSpell playerSpell;

    public GameCanvas() {
        this.player = new Player();
        this.background = new Background();
        this.enemy = new Enemy();
        this.playerSpell = new PlayerSpell();
        this.playerSpell.x = this.player.x;
        this.playerSpell.y = this.player.y;

        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyPressed.getInstance().upPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyPressed.getInstance().downPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyPressed.getInstance().rightPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyPressed.getInstance().leftPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyPressed.getInstance().upPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyPressed.getInstance().downPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyPressed.getInstance().rightPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyPressed.getInstance().leftPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        this.background.render(g);
        this.player.render(g);
        this.enemy.render(g);
        this.playerSpell.render(g);
    }

    public void run() {
        this.background.run();
        this.player.run();
        this.enemy.run();
        this.playerSpell.run();
    }
}
