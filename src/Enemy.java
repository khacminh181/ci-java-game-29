import java.awt.*;

public class Enemy {
    Image image;
    Vector2D position;

    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position = new Vector2D((float) Math.random() * 384, 0);
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run() {
        this.position.y++;
    }
}
