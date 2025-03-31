package ckollmeier.de;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
    @Test
    void passwordHasMinEightCharacters_shouldReturnTrue_whenPasswordHasEightCharacters() {
        String password = "12345678";

        boolean result = PasswordValidation.passwordHasMinEightCharacters(password);

        assertTrue(result);
    }

    @Test
    void passwordHasMinEightCharacters_shouldReturnTrue_whenPasswordHasMoreThanEightCharacters() {
        String password = "1234567890";

        boolean result = PasswordValidation.passwordHasMinEightCharacters(password);

        assertTrue(result);
    }

    @Test
    void passwordHasMinEightCharacters_shouldReturnFalse_whenPasswordHasLessThanEightCharacters() {
        String password = "1234567";

        boolean result = PasswordValidation.passwordHasMinEightCharacters(password);

        assertFalse(result);
    }

    @Test
    void passwordHasMinEightCharacters_shouldReturnFalse_whenPasswordIsEmpty() {
        String password = "";

        boolean result = PasswordValidation.passwordHasMinEightCharacters(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsDigits_shouldReturnTrue_whenPasswordContainsOnlyDigits() {
        String password = "1234567890";

        boolean result = PasswordValidation.passwordContainsDigits(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsDigits_shouldReturnTrue_whenPasswordContainsDigitsAndCharacters() {
        String password = "1A345BC6_78$90";

        boolean result = PasswordValidation.passwordContainsDigits(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsDigits_shouldReturnFalse_whenPasswordContainsNoDigits() {
        String password = "A$B_D@";

        boolean result = PasswordValidation.passwordContainsDigits(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsDigits_shouldReturnFalse_whenPasswordIsEmpty() {
        String password = "";

        boolean result = PasswordValidation.passwordContainsDigits(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsUpperCaseAndLowerCase_shouldReturnTrue_whenPasswordHasUpperCaseAndLowerCase() {
        String password = "1A345bc6_78$90";

        boolean result = PasswordValidation.passwordContainsUpperCaseAndLowerCase(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsUpperCaseAndLowerCase_shouldReturnFalse_whenPasswordOnlyContainsUpperCase() {
        String password = "1A345BC6_78$90";

        boolean result = PasswordValidation.passwordContainsUpperCaseAndLowerCase(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsUpperCaseAndLowerCase_shouldReturnFalse_whenPasswordOnlyContainsLowerCase() {
        String password = "1a345bc6_78$90";

        boolean result = PasswordValidation.passwordContainsUpperCaseAndLowerCase(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsUpperCaseAndLowerCase_shouldReturnFalse_whenPasswordisEmpty() {
        String password = "";

        boolean result = PasswordValidation.passwordContainsUpperCaseAndLowerCase(password);

        assertFalse(result);
    }

    @Test
    void passwordIsNoCommonPassword_shouldReturnTrue_whenPasswordIsNoCommonPassword() {
        String password = "1A345bc6_78$90";

        boolean result = PasswordValidation.passwordIsNoCommonPassword(password);

        assertTrue(result);
    }

    @Test
    void passwordIsNoCommonPassword_shouldReturnTrue_whenPasswordIsEmpty() {
        String password = "";

        boolean result = PasswordValidation.passwordIsNoCommonPassword(password);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "12345678",
            "1234567890",
            "password",
            "passwort",
            "secret",
            "deine mudda"
    })
    void passwordIsNoCommonPassword_shouldReturnFalse_whenPasswordIsCommonInUpperCaseAndLowerCase(String password) {
        boolean result = PasswordValidation.passwordIsNoCommonPassword(password);

        assertFalse(result);

        result = PasswordValidation.passwordIsNoCommonPassword(password.toLowerCase());

        assertFalse(result);

        result = PasswordValidation.passwordIsNoCommonPassword(password.toUpperCase());

        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1A345bc_67890",
            "1A345bc678@90",
            "1A345bc6789$0",
    })
    void passwordContainsSpecialCharacters_shouldReturnTrue_whenPasswordContainsSpecialCharacters(String password) {
        boolean result = PasswordValidation.passwordContainsSpecialCharacters(password);

        assertTrue(result);
    }

    @Test
    void passwordContainsSpecialCharacters_shouldReturnFalse_whenPasswordContainsNoSpecialCharacters() {
        String password = "1A345bc67890";

        boolean result = PasswordValidation.passwordContainsSpecialCharacters(password);

        assertFalse(result);
    }

    @Test
    void passwordContainsSpecialCharacters_shouldReturnFalse_whenPasswordIsEmpty() {
        String password = "";

        boolean result = PasswordValidation.passwordContainsSpecialCharacters(password);

        assertFalse(result);
    }
}