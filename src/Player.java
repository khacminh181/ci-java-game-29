import java.awt.*;
import java.util.ArrayList;

public class Player {
    Image image;
    int x;
    int y;

    ArrayList<PlayerSpell> playerSpells;

    public Player() {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x = 175;
        this.y = 500;

        this.playerSpells = new ArrayList<>();
    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);

        // chay ham render cua tung spell
        for (int i = 0; i < this.playerSpells.size(); i++) {
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.render(g);
        }
    }

    int count = 0;
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
        if (KeyPressed.getInstance().shootPressed && count >= 20) {
            this.castSpell();
            count = 0;
        } else {
            count++;
        }

        this.x = Utils.clamp(this.x, 0, 384 - 32);
        this.y = Utils.clamp(this.y, 0, 600 - 40);
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
        newSpell.x = this.x;
        newSpell.y = this.y;
        playerSpells.add(newSpell);
    }
}
