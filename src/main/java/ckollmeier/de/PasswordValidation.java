package ckollmeier.de;

public class PasswordValidation {
    public static boolean passwordHasMinEightCharacters(String password) {
        // Implementation
        return password.length() >= 8;
    }

    public static boolean passwordContainsDigits(String password) {
        // Implementation
        return false;
    }

    public static boolean passwordContainsUpperCaseAndLowerCase(String password) {
        // Implementation
        return false;
    }

    public static boolean passwordIsNoCommonPassword(String password) {
        // Implementation
        return false;
    }
}
