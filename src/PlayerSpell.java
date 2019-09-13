import java.awt.*;

public class PlayerSpell {
    Image image;
    int x;
    int y;

    public PlayerSpell() {
        this.image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        this.x = 0;
        this.y = 0;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    public void run() {
        this.y--;
    }
}
