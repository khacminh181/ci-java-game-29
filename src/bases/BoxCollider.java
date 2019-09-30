package bases;

public class BoxCollider{
    Vector2D positon;
    float width, height;
    Vector2D anchor;

    public BoxCollider(GameObject master, float width, float height) {
        this.positon = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }

    public float top() {
        return this.positon.y - this.anchor.y*this.height;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.positon.x - this.anchor.x*this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    //ToDo: can lam gi dodo
    public boolean collideWith(BoxCollider other) {
        return this.right() >= other.left() &&
                this.left() <= other.right() &&
                this.bot() >= other.top() &&
                this.top() <= other.bot();
    }
}
