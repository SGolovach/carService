package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

import static org.testng.Assert.*;

public class MainCommandTest {
    Command command;

    @BeforeMethod
    public void setUp() {
        command = new MainCommand();
    }

    @AfterMethod
    public void tearDown() {
        command = null;
    }

    @Test
    public void testExecute() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        String actual = command.execute(request);
        assertEquals(actual, "/WEB-INF/jsp/main.jsp");
    }
}