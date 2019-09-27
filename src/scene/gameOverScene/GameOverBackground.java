package scene.gameOverScene;

import bases.GameObject;
import bases.KeyPressed;
import renderer.ImageRenderer;
import scene.SceneManager;
import scene.welcomeScene.GameWelcomeScene;

public class GameOverBackground extends GameObject implements Runnable {

    public GameOverBackground() {
        this.renderer = new ImageRenderer("assets/images/scenes/game-over-background.jpg");
    }

    @Override
    public void run() {
        if (KeyPressed.getInstance().anyKeyPressed) {
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}
