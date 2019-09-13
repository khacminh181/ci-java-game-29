public class Utils {

    /**
     *
     *
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }

        return value;
    }
}
