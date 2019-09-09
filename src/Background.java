import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background {
    Image image;
    int x;
    int y;

    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.x = 0;
        this.y = 600 - 3109;
    }

    /**
     * Render image
     *
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    /**
     * Handle
     */
    public void run() {
        if (this.y < 0) {
            this.y += 10;
        } else {
            this.y = -3109 + 600;
        }
    }
}
