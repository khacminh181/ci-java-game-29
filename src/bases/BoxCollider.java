package bases;

public class BoxCollider {
    Vector2D positon;
    float width, height;

    public BoxCollider(Vector2D positon, float width, float height) {
        this.positon = positon;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.positon.y;
    }

    public float bot() {
        return this.positon.y + this.height;
    }

    public float left() {
        return this.positon.x;
    }

    public float right() {
        return this.positon.x + this.width;
    }

    public static void main(String[] args) {
        BoxCollider box1 = new BoxCollider(new Vector2D(0, 0), 5, 5);
        BoxCollider box2 = new BoxCollider(new Vector2D(4, 4), 5, 5);

        System.out.println(box1.collideWith(box2));
    }

    //ToDo: can lam gi dodo
    public boolean collideWith(BoxCollider other) {
        return this.right() >= other.left() &&
                this.left() <= other.right() &&
                this.bot() >= other.top() &&
                this.top() <= other.bot();
    }
}
