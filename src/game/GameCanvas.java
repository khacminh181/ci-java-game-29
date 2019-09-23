package game;

import bases.GameObject;
import bases.KeyPressed;
import entities.Background;
import entities.Enemy;
import entities.EnemySpawner;
import entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    EnemySpawner enemySpawner;
    Enemy enemy;

    public GameCanvas() {
        this.background = new Background();
        this.player = GameObject.recycle(Player.class);
        enemySpawner = new EnemySpawner();
//        enemy = new Enemy();
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
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyPressed.getInstance().shootPressed = true;
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
                }  else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyPressed.getInstance().shootPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        GameObject.renderAll(g);
    }

}
