package ckollmeier.de;

import org.junit.jupiter.api.Test;

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
}