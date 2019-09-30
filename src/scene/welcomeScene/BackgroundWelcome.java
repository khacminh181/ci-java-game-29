package scene.welcomeScene;

import bases.GameObject;
import bases.KeyPressed;
import renderer.ImageRenderer;
import scene.GamePlayScene;
import scene.SceneManager;

public class BackgroundWelcome extends GameObject {

    public BackgroundWelcome() {
        this.anchor.set(0,0);
        this.renderer = new ImageRenderer("assets/images/scenes/menu.png");
    }

    @Override
    public void run() {
        if (KeyPressed.getInstance().anyKeyPressed) {
            SceneManager.signNewScene(new GamePlayScene());
        }
    }
}
