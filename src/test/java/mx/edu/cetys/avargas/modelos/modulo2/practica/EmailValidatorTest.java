package mx.edu.cetys.avargas.modelos.modulo2.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class EmailValidatorTest {

    static EmailValidator emailValidator;

    @BeforeEach
    void BeforeAll() {
        System.out.println("Before each Test");
        emailValidator = new EmailValidator();
    }


    @Test
    void testValidEmail_HappyPath() {
        // Validate
        assertTrue(emailValidator.isValid("4arouieN@cetys.mx"));
        assertTrue(emailValidator.isValid("4aro.+-_uieN@cetys.mx"));
    }

    @Test
    void testValidEmail_NDomain() {
        // Validate
        assertTrue(emailValidator.isValid("4arouieN@cetys.com"));

    }

    @Test
    void testValidEmail_SadPath() {
        // Validate
        assertFalse(emailValidator.isValid("4arouieN@cetys.c!om.com.cpm..mx"));
        assertFalse(emailValidator.isValid("4arouieN@cetys.mx1"));
        assertFalse(emailValidator.isValid("4arouieN@cetys.m"));
        assertFalse(emailValidator.isValid("4arouieN@cetys.mdsafadsfx"));
        assertFalse(emailValidator.isValid("4arouieN@cetasfdasfasdjgasdgasdjgdaskgjasdkgjasdkgjasdkgjkadsjgkadsjgkdasjgkdsagjkasgjaskgjasdkjgaskjgaksjagkays.mx"));
        assertFalse(emailValidator.isValid("4arouieN@cet$ys.mx"));
        assertFalse(emailValidator.isValid("4arouieN@ce tys.mx"));
        assertFalse(emailValidator.isValid("4arouieN@cetysmx"));
        assertFalse(emailValidator.isValid(""));
        assertFalse(emailValidator.isValid("4aroui$eN@cetys.commx.aarob.com"));
        assertFalse(emailValidator.isValid("4aroui@en@cetys.commx.aarob.com"));
        assertFalse(emailValidator.isValid("4arouien@cetys.commx.aarob.com"));
        assertFalse(emailValidator.isValid("aaron@cetys.mx"));
        assertFalse(emailValidator.isValid("Aaro n4@cetys.mx"));
        assertFalse(emailValidator.isValid("4aroasfadsfasdfasdgasgdsafsadgadsgdasfadsgknasdghq34128u8gyasydgn4A@cetys.mx"));
        assertFalse(emailValidator.isValid(null));

    }

//    @Test
//    void test_mario(){
//
//
//        assertFalse(emailValidator.isValid("2aeiouM@h"));
//        assertFalse(emailValidator.isValid("2aeiouM@hotmai_l.com"));
//        assertFalse(emailValidator.isValid("aeiouM@hotmail.com"));
//        assertFalse(emailValidator.isValid("aeiou@cetys.mx"));
//        assertFalse(emailValidator.isValid("aeiouA@Yahoo.educationnn"));
//        assertFalse(emailValidator.isValid("aeiou 1C@Yahoo.com"));
//        assertFalse(emailValidator.isValid("aeio?u5M@google.com "));
//        assertFalse(emailValidator.isValid("masdm.cetys.edu"));
//        assertFalse(emailValidator.isValid("masdmA@cetys.edu"));
//        assertFalse(emailValidator.isValid("aeiousandaisndiuasndijansdjnasijdnaisndajisndijasndiasnD@cetys.edu.mx"));
//        assertFalse(emailValidator.isValid("aeiounD@cetyasdnasdhaiusndasndajsndiasunbdiansiasjnds.edu.mx"));
//        assertFalse(emailValidator.isValid("2ae%iouM@hotmail.com"));
//        assertFalse(emailValidator.isValid("2aeiouM@hotmail.c"));
//    }

    @Test
    void validateEmail_CustomSpecialCharacter(){
        emailValidator = new EmailValidator("!#$%");
        assertFalse(emailValidator.isValid("4arouieN!#$%@cetys.com"));
    }

    @Test
    void testValidEmail_HappyPath2() {
        // Validate
        assertTrue(emailValidator.isValid("4arouieN@cetys.mx"));
        assertTrue(emailValidator.isValid("4aro.+-_uieN@cetys.mx"));


    }
    @Test
    void testValidEmail_HappyPath3() {
        // Validate
        assertTrue(emailValidator.isValid("4arouieN@cetys.mx"));
        assertTrue(emailValidator.isValid("4aro.+-_uieN@cetys.mx"));


    }

    @AfterAll
    static void afterAll() {
        emailValidator = null;
    }

}