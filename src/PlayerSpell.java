import java.awt.*;

public class PlayerSpell {
    Image image;
    Vector2D position;

//    Vector2D position = new Vector2D(0, 0);

    public PlayerSpell() {
        this.image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        this.position = new Vector2D();
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run() {
        this.position.y--;
    }
}
