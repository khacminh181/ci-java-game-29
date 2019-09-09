public class KeyPressed {
    boolean upPressed;
    boolean downPressed;
    boolean rightPressed;
    boolean leftPressed;

    private static final KeyPressed INSTANCE = new KeyPressed();

    private KeyPressed() {
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
    }

    public static KeyPressed getInstance() {
        return INSTANCE;
    }
}
