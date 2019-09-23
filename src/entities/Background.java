package entities;

import bases.GameObject;
import bases.Vector2D;
import renderer.ImageRenderer;

public class Background extends GameObject {
    public Background() {
        this.renderer = new ImageRenderer("assets/images/background/0.png");
        this.position = new Vector2D(0, 600 - 3109);
    }

    @Override
    public void run() {
        if (this.position.y < 0) {
            this.position.y += 10;
        } else {
            this.position.y = -3109 + 600;
        }
    }
}
