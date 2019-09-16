package bases;

import java.awt.*;

public class GameObject {
    public Image image;
    public Vector2D position;

    public GameObject() {
        System.out.println("dang ke thua nay");
        this.position = new Vector2D(0, 0);
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run() {

    }
}
