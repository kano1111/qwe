package com.devxschool;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.*;

public class PasswordValidatorTest {

    PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void isValidTest() {
        assertTrue("Checking a valid password: Password12345!", passwordValidator.isValid("Password12345!"));
    }

    @Test
    public void hasSpecialCharacterTest() {
        asList("!", "@", "#", "$", "%", "^", "&", "*", "(", ")")
                .forEach(element ->
                        assertTrue("Special character does not exist: " + element, passwordValidator.hasSpecialCharacter(element))
                );
    }

    @Test
    public void hasNumberTest() {
        assertTrue("Number is incorrect", passwordValidator.hasNumber("123"));
    }

    @Test
    public void hasLowerCaseTest() {
        assertTrue("Lower Case is incorrect", passwordValidator.hasLowerCase("abc"));
    }

    @Test
    public void hasUpperCaseTest() {
        assertTrue("Upper Case is incorrect", passwordValidator.hasUpperCase("ABC"));
    }

    @Test
    public void checkSizeTest() {
        assertTrue("Size is incorrect", passwordValidator.checkSize("12345678"));
    }

    @Test
    public void errorMessageTest(){
        assertFalse("Error message is incorrect", passwordValidator.errorMessage("error"));
    }

    @Test
    public void isValidTest2() {
        assertFalse("Checking a valid password: Password12345!", passwordValidator.isValid("Password12345"));
    }
    @Test
    public void isValidTest3() {
        assertFalse("Checking a valid password: Password12345!", passwordValidator.isValid("Password!!!!!"));
    }
    @Test
    public void isValidTest4() {
        assertFalse("Checking a valid password: Password12345!", passwordValidator.isValid("123456789!"));
    }

    @Test
    public void hasSpecialCharacterTest2() {
        asList("`", "_", "<", ">", "a", "1", "?", ".", ",", "+")
                .forEach(element ->
                        assertFalse("Special character should not exist: " + element, passwordValidator.hasSpecialCharacter(element))
                );
    }

    @Test
    public void hasNumberTest2() {
        assertFalse("Number is incorrect", passwordValidator.hasNumber("***"));
        assertFalse("Number is incorrect", passwordValidator.hasNumber("abc"));
    }

    @Test
    public void hasLowerCaseTest2() {
        assertFalse("Lower Case is incorrect", passwordValidator.hasLowerCase("ABC"));
        assertFalse("Lower Case is incorrect", passwordValidator.hasLowerCase("123"));
    }

    @Test
    public void hasUpperCaseTest2() {
        assertFalse("Upper Case is incorrect", passwordValidator.hasUpperCase("abc"));
        assertFalse("Lower Case is incorrect", passwordValidator.hasLowerCase("123"));
    }

    @Test
    public void checkSizeTest2() {
        assertFalse("Size is incorrect", passwordValidator.checkSize("1234567"));
    }

    @Test
    public void errorMessageTest2(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        passwordValidator.errorMessage("error");
        assertEquals("Error message is incorrect",
                "Password is invalid, please check: error\n",
                out.toString());
    }
}
