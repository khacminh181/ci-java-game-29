package entities.player;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.enemy.Enemy;
import renderer.ImageRenderer;

public class PlayerSpell extends GameObject {
    public PlayerSpell() {
        this.renderer = new ImageRenderer("assets/images/player-spells/a/0.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24, 24);
    }

    public void run() {
        this.position.y -= 5;

        Enemy enemy = GameObject.checkCollider(this, Enemy.class);
        if (enemy != null) {
            System.out.println("dang va cham");
            enemy.deactive();
            this.deactive();
        }
    }
}
