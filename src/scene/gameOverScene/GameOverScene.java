package scene.gameOverScene;

import bases.GameObject;
import scene.Scene;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        GameOverBackground gameOverBackground = GameObject.recycle(GameOverBackground.class);
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
