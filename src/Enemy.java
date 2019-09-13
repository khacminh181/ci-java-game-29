import java.awt.*;

public class Enemy {
    Image image;
    int x;
    int y;

    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.x = (int) Math.random() * 384;
        this.y = 0;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    public void run() {
        this.y++;
    }
}
