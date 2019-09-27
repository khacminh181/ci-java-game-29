package scene;

import bases.GameObject;
import entities.Background;
import entities.enemy.EnemySpawner;
import entities.player.Player;

public class GamePlayScene extends Scene{
    @Override
    public void init() {
        Background background = GameObject.recycle(Background.class);
        Player player = GameObject.recycle(Player.class);
        EnemySpawner enemySpawner =  GameObject.recycle(EnemySpawner.class);
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
