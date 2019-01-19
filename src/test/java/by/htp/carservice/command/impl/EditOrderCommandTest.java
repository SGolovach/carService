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

public class EditOrderCommandTest {
    Command command;

    @BeforeMethod
    public void setUp() {
        command = new EditOrderCommand();
    }

    @AfterMethod
    public void tearDown() {
        command = null;
    }

    @Test
    public void testExecute() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        User user = new User();
        user.setLogin("user");
        user.setIdUser(2);
        user.setRoleId(1);
        user.setPassword("password");
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("user")).thenReturn(user);
        Mockito.when(request.getMethod()).thenReturn("get");
        String actual = command.execute(request);
        assertEquals(actual, "/WEB-INF/jsp/editorder.jsp");
    }
}