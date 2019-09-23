package entities.enemy;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import renderer.ImageRenderer;

public class Enemy extends GameObject {
    public Enemy() {
        this.renderer = new ImageRenderer("assets/images/enemies/level0/pink/0.png");
        this.position = new Vector2D((float) Math.random() * 384, 0);
        this.boxCollider = new BoxCollider(this, 28, 28);
    }

    @Override
    public void run() {
        this.deactiveIfNeeded();
        this.position.addUp(0, 1);
    }

    public void deactiveIfNeeded() {
        if (this.position.y > 600) {
            deactive();
        }
    }

    @Override
    public void reset() {
        super.reset();
    }
}
