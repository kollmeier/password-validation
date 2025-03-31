package ckollmeier.de;

import java.util.Arrays;

public class PasswordValidation {
    public static boolean passwordHasMinEightCharacters(String password) {
        // Implementation
        return password.length() >= 8;
    }

    public static boolean passwordContainsDigits(String password) {
        // Implementation
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean passwordContainsUpperCaseAndLowerCase(String password) {
        boolean lc = false;
        boolean uc = false;
        for (int i = 0; i < password.length(); i++) {
            lc = lc || Character.isLowerCase(password.charAt(i));
            uc = uc || Character.isUpperCase(password.charAt(i));
            if (lc && uc) {
                return true;
            }
        }
        return false;
    }

    public static boolean passwordIsNoCommonPassword(String password) {
        String[] commonPasswords =
                new String[] {
                        "12345678",
                        "1234567890",
                        "password",
                        "passwort",
                        "secret",
                        "deine mudda"
                };

        return (Arrays.stream(commonPasswords).noneMatch(
                cp -> cp.equalsIgnoreCase(password)
        ));
    }

    public static boolean passwordContainsSpecialCharacters(String password) {
        return (Arrays.stream(PasswordUtility.SPECIALCHARACTERS).anyMatch(password::contains));
    }

    public static boolean passwordIsValid(String password) {
        return passwordHasMinEightCharacters(password)
                && passwordIsNoCommonPassword(password)
                && passwordContainsDigits(password)
                && passwordContainsUpperCaseAndLowerCase(password)
                && passwordIsNoCommonPassword(password)
                && passwordContainsSpecialCharacters(password);
    }
}
