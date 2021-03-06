package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.entity.impl.User;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.testng.Assert.*;

public class LogOutCommandTest {
    Command command;

    @BeforeMethod
    public void setUp() {
        command = new LogOutCommand();
    }

    @AfterMethod
    public void tearDown() {
        command = null;
    }

    @Test
    public void testExecute() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        String actual = command.execute(request);
        assertEquals(actual, "/WEB-INF/jsp/main.jsp");
    }
}