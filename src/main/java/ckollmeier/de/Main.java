package ckollmeier.de;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your new password: ");
        System.out.printf("""
                        (At least 8 characters, only numbers and digits\s
                        and %s. One number, one small letter, one capital letter
                        and one special character mandatory)
                        """,
                String.join(", ", PasswordUtility.SPECIALCHARACTERS));
        String password = scanner.nextLine();
        if (!PasswordValidation.passwordIsValid(password)) {
            System.out.println("Password is invalid");
            return;
        }
        System.out.println("Please confirm your new password: ");
        String confirmPassword = scanner.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match");
            return;
        }
        System.out.println("Password valid");
    }
}