package entities.player;
import bases.*;
import renderer.ImageRenderer;

public class Player extends GameObject {
    FrameCounter frameCounter;
    public Player() {
        this.renderer = new ImageRenderer("assets/images/players/straight/0.png");
        this.position = new Vector2D(175, 500);
        this.frameCounter = new FrameCounter(20);
    }

    public void run() {
        float vx = 0, vy = 0;
        deactiveIfNeeded();
        if (KeyPressed.getInstance().upPressed) {
            vy  = -5;
        }
        if (KeyPressed.getInstance().downPressed) {
            vy = 5;
        }
        if (KeyPressed.getInstance().rightPressed) {
            vx = 5;
        }
        if (KeyPressed.getInstance().leftPressed) {
            vx = -5;
        }
        if (KeyPressed.getInstance().shootPressed && frameCounter.expired) {
            this.castSpell();
            frameCounter.reset();
        } else {
            frameCounter.run();
        }

        this.position.x = Utils.clamp(this.position.x, 0, 384 - 32);
        this.position.y = Utils.clamp(this.position.y, 0, 600 - 40);

        this.velocity.set(vx, vy);
        super.run();
    }

    /**
     * Khoi tao 1 vien dan moi
     * Gan gia tri x, y ban dau trung voi player
     * Add vao trong arraylist playerSpells
     */
    private void castSpell() {
        PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
        newSpell.position.set(this.position.x, this.position.y);
    }

    public void deactiveIfNeeded() {
        if (this.position.y < 0) {
            deactive();
        }
    }
}
