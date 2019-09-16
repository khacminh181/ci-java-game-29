import java.awt.*;
import java.util.ArrayList;

public class Player {
    Image image;
    Vector2D position;

    ArrayList<PlayerSpell> playerSpells;

    public Player() {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(175, 500);

        this.playerSpells = new ArrayList<>();
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);

        // chay ham render cua tung spell
        for (int i = 0; i < this.playerSpells.size(); i++) {
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.render(g);
        }
    }

    int count = 0;
    public void run() {
        if (KeyPressed.getInstance().upPressed) {
            this.position.y -= 5;
        }
        if (KeyPressed.getInstance().downPressed) {
            this.position.y += 5;
        }
        if (KeyPressed.getInstance().rightPressed) {
            this.position.x += 5;
        }
        if (KeyPressed.getInstance().leftPressed) {
            this.position.x -= 5;
        }
        if (KeyPressed.getInstance().shootPressed && count >= 20) {
            this.castSpell();
            count = 0;
        } else {
            count++;
        }

        this.position.x = Utils.clamp(this.position.x, 0, 384 - 32);
        this.position.y = Utils.clamp(this.position.y, 0, 600 - 40);
        // chay tung ham run cua spell
        for (int i = 0; i < this.playerSpells.size(); i++) {
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.run();
        }
    }

    /**
     * Khoi tao 1 vien dan moi
     * Gan gia tri x, y ban dau trung voi player
     * Add vao trong arraylist playerSpells
     */
    private void castSpell() {
        PlayerSpell newSpell = new PlayerSpell();
        newSpell.position.x = this.position.x;
        newSpell.position.y = this.position.y;
        playerSpells.add(newSpell);
    }
}
