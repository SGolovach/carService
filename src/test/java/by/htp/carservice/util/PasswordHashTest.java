package by.htp.carservice.util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PasswordHashTest {
    PasswordHash passwordHash;

    @BeforeMethod
    public void setUp() {
        passwordHash = new PasswordHash();
    }

    @AfterMethod
    public void tearDown() {
        passwordHash = null;
    }

    @DataProvider
    public Object[][] passData() {
        return new Object[][]{
                {"pass", "28c6d978b92b29774fbc89e8ce3d76ecd239b21890a827b1fcd7350e0070cc20"},
                {"12345678","de3741539c32d367f6556addbdca97dfca2002317fbb03c00ac308e2703a8ab3"},
                {"logout", "78229d6872c2fdfbdde1ffcd0b8fb8943b85fb1da4f62596a8659152453f8a84"},
                {"signup", "e871d7494f670de57092c302c376cecc6b49b390fb8592a51a3f571b0b6bdbcd"},
                {"login", "8b7df50fe3a291d187d1e4626b300644b5f346017e83b1a8497f2fe03371b265"},
                {"admin", "79584cf9c4b7118dd5feb956c3c00e363e04183d6a2a66a99fc3b7064541c395"},
        };
    }

    @Test (dataProvider = "passData")
    public void testGetHashPass(String pass,String expected) {
        String actual = passwordHash.getHashPass(pass);
        assertEquals(actual,expected);
    }
}