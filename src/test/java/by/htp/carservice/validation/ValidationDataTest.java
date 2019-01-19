package by.htp.carservice.validation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidationDataTest {
    ValidationData validation;

    @BeforeMethod
    public void setUp() {
        validation = new ValidationData();
    }

    @AfterMethod
    public void tearDown() {
        validation = null;
    }

    @DataProvider
    public Object[][] validLogin() {
        return new Object[][]{
                {"log", false},
                {"login", true},
        };
    }

    @Test(dataProvider = "validLogin")
    public void testValidateLogin(String str, boolean expected) {
        boolean actual = validation.validateLogin(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validPassword() {
        return new Object[][]{
                {"12345", false},
                {"12345678", true},
        };
    }

    @Test(dataProvider = "validPassword")
    public void testValidatePassword(String str, boolean expected) {
        boolean actual = validation.validatePassword(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validName() {
        return new Object[][]{
                {"a", false},
                {"Sergei", true},
        };
    }

    @Test(dataProvider = "validName")
    public void testValidateName(String str, boolean expected) {
        boolean actual = validation.validateName(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validPhone() {
        return new Object[][]{
                {"12345", false},
                {"80291234567", true},
        };
    }

    @Test(dataProvider = "validPhone")
    public void testValidatePhone(String str, boolean expected) {
        boolean actual = validation.validatePhone(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validEmail() {
        return new Object[][]{
                {"mail.com", false},
                {"mail@mail.com", true},
        };
    }

    @Test(dataProvider = "validEmail")
    public void testValidateEmail(String str, boolean expected) {
        boolean actual = validation.validateEmail(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validBrand() {
        return new Object[][]{
                {"f", false},
                {"toyota", true},
        };
    }

    @Test(dataProvider = "validBrand")
    public void testValidateBrand(String str, boolean expected) {
        boolean actual = validation.validateBrand(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validModel() {
        return new Object[][]{
                {"a", false},
                {"camry", true},
        };
    }

    @Test(dataProvider = "validModel")
    public void testValidateModel(String str, boolean expected) {
        boolean actual = validation.validateModel(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validYear() {
        return new Object[][]{
                {"1", false},
                {"2010", true},
        };
    }

    @Test(dataProvider = "validYear")
    public void testValidateYear(String str, boolean expected) {
        boolean actual = validation.validateYear(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validCodeVin() {
        return new Object[][]{
                {"545454sd5454", false},
                {"1234567890asdfghj", true},
        };
    }

    @Test(dataProvider = "validCodeVin")
    public void testValidateCodeVin(String str, boolean expected) {
        boolean actual = validation.validateCodeVin(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validFuel() {
        return new Object[][]{
                {"g", false},
                {"petrole", true},
        };
    }

    @Test(dataProvider = "validFuel")
    public void testValidateFuel(String str, boolean expected) {
        boolean actual = validation.validateFuel(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validDescription() {
        return new Object[][]{
                {"", false},
                {"Description", true},
        };
    }

    @Test(dataProvider = "validDescription")
    public void testValidateDescription(String str, boolean expected) {
        boolean actual = validation.validateDescription(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validCost() {
        return new Object[][]{
                {"11", false},
                {"125.25", true},
        };
    }

    @Test(dataProvider = "validCost")
    public void testValidateCost(String str, boolean expected) {
        boolean actual = validation.validateCost(str);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] validNumberInvoice() {
        return new Object[][]{
                {"12345", false},
                {"101", true},
        };
    }

    @Test(dataProvider = "validNumberInvoice")
    public void testValidateNumberInvoice(String str, boolean expected) {
        boolean actual = validation.validateNumberInvoice(str);
        assertEquals(actual, expected);
    }
}