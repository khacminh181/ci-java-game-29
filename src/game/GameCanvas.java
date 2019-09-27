package game;

import bases.GameObject;
import bases.KeyPressed;
import scene.SceneManager;
import scene.welcomeScene.GameWelcomeScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends JPanel {
    public GameCanvas() {
        SceneManager.signNewScene(new GameWelcomeScene());
        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = true;
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
                KeyPressed.getInstance().anyKeyPressed = false;
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
        g.fillRect(0, 0, 700, 600);
        GameObject.renderAll(g);
    }

}
