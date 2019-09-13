import java.awt.*;

public class Player {
    Image image;
    int x;
    int y;

    public Player() {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x = 175;
        this.y = 500;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    public void run() {
        if (KeyPressed.getInstance().upPressed) {
            this.y -= 5;
        }
        if (KeyPressed.getInstance().downPressed) {
            this.y += 5;
        }
        if (KeyPressed.getInstance().rightPressed) {
            this.x += 5;
        }
        if (KeyPressed.getInstance().leftPressed) {
            this.x -= 5;
        }

        this.x = Utils.clamp(this.x, 0, 384 - 32);
        this.y = Utils.clamp(this.y, 0, 600 - 40);
    }
}
