package utils;

import java.util.Random;

public class TestDataGenerator {

    public static String generateUsername() {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 7; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }

        for (int i = 0; i < 4; i++) {
            result.append(random.nextInt(10));
        }

        return result.toString();
    }
}
