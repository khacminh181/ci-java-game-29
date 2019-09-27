package entities.player;
import bases.*;
import renderer.Animation;
import renderer.ImageRenderer;
import renderer.Renderer;
import scene.SceneManager;
import scene.gameOverScene.GameOverScene;

public class Player extends GameObject {
    FrameCounter frameCounter;
    public Player() {
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/players/straight/0.png"),
                SpriteUtils.loadImage("assets/images/players/straight/1.png"),
                SpriteUtils.loadImage("assets/images/players/straight/2.png"),
                SpriteUtils.loadImage("assets/images/players/straight/3.png"),
                SpriteUtils.loadImage("assets/images/players/straight/4.png"),
                SpriteUtils.loadImage("assets/images/players/straight/5.png"),
                SpriteUtils.loadImage("assets/images/players/straight/6.png")
                );
        this.position = new Vector2D(175, 500);
        this.frameCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this, 32, 48);
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

//        this.position.x = Utils.clamp(this.position.x, 0, 384 - 32);
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
        int numberB = 9;
        double startAngle = -120;
        double endAngle = -60;
        double step = (endAngle - startAngle)/(numberB - 1);

        for (int i = 0; i < numberB; i++) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(this.position.x, this.position.y);
            newSpell.velocity.setAngle(Math.toRadians(startAngle + (step * i)));
        }
    }

    public void deactiveIfNeeded() {
        if (this.position.y < 0) {
            deactive();
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new GameOverScene());
    }
}
