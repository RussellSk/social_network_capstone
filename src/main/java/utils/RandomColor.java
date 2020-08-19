package utils;

import java.util.Random;

public class RandomColor {
    private static final Random random;

    static {
        random = new Random();
    }

    /**
     * Randomly creating Color
     * @return String color in format #FFFFFF
     */
    public static String nextColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return String.format("#%02x%02x%02x", red, green, blue);
    }
}
