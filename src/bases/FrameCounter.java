package bases;

public class FrameCounter {
    int count;
    int limit;
    public boolean expired;

    public FrameCounter(int limit) {
        this.count = 0;
        this.limit = limit;
        this.expired = false;
    }

    public void run() {
        if (count >= limit) {
            expired = true;
        } else {
            count++;
        }
    }

    public void reset() {
        count = 0;
        expired = false;
    }
}
