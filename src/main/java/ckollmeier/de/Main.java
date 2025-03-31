package ckollmeier.de;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your new password: ");
        String password = scanner.nextLine();
        System.out.println("Please confirm your new password: ");
        String confirmPassword = scanner.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match");
            return;
        }
        if (!PasswordValidation.passwordIsValid(password)) {
            System.out.println("Password is invalid");
            return;
        }
        System.out.println("Password valid");
    }
}