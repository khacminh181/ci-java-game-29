package entities;

import bases.SpriteUtils;
import bases.Vector2D;

import java.awt.*;

public class Background {
    Image image;
    Vector2D position;

    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position = new Vector2D(0, 600 - 3109);
    }

    /**
     * Render image
     *
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    /**
     * Handle
     */
    public void run() {
        if (this.position.y < 0) {
            this.position.y += 10;
        } else {
            this.position.y = -3109 + 600;
        }
    }
}
