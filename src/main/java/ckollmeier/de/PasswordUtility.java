package ckollmeier.de;

import java.util.Random;

public class PasswordUtility {
    public static final String[] SPECIALCHARACTERS = new String[]{"@", "_", "$"};

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        // Eight letters, alternatly UC
        for (int i = 0; i < 4; i++) {
            String letter = Character.toString((char) (rand.nextInt(26) + 'a'));

            if (i % 2 == 0) {
                letter = letter.toUpperCase();
            }
            password.append(letter);
        }
        // three digits replace letters at random positions
        for (int i = 0; i < 3; i++) {
            String digit = Character.toString((char) (rand.nextInt(10) + '0'));
            int position = rand.nextInt(password.length());

            password.insert(position, digit);
        }
        // one special character
        String special = SPECIALCHARACTERS[rand.nextInt(3)];
        int position = rand.nextInt(password.length());
        password.insert(position, special);

        return password.toString();
    }
}
