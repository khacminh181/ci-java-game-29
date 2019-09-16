package entities;

import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

import java.awt.*;

public class PlayerSpell extends GameObject {
    public PlayerSpell() {
        this.image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        this.position = new Vector2D();
    }

    public void run() {
        this.position.y--;
    }
}
