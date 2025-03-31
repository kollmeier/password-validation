package ckollmeier.de;

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
        // Implementation
        return false;
    }
}
