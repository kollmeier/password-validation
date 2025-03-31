package ckollmeier.de;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilityTest {
    @Test
    void generatePasswordGeneratesValidPassword() {
        String password = PasswordUtility.generatePassword();

        assertTrue(PasswordValidation.passwordHasMinEightCharacters(password));
        assertTrue(PasswordValidation.passwordContainsDigits(password));
        assertTrue(PasswordValidation.passwordContainsUpperCaseAndLowerCase(password));
        assertTrue(PasswordValidation.passwordContainsSpecialCharacters(password));
        assertTrue(PasswordValidation.passwordIsNoCommonPassword(password));
    }

}