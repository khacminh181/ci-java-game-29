package entities;

import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

public class Enemy extends GameObject {
    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position = new Vector2D((float) Math.random() * 384, 0);
    }

    @Override
    public void run() {
        this.position.y++;
    }
}
