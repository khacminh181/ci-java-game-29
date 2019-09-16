package bases;

public class KeyPressed {
    public boolean upPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean leftPressed;
    public boolean shootPressed;

    private static final KeyPressed INSTANCE = new KeyPressed();
    
    private KeyPressed() {
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.shootPressed = false;
    }

    public static KeyPressed getInstance() {
        return INSTANCE;
    }
}
