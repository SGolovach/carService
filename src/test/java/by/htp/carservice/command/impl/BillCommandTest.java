package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.connectionpool.ConnectionPool;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.testng.Assert.*;

public class BillCommandTest {
    Command command;

    @BeforeMethod
    public void setUp() {
        command = new BillCommand();
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
        user.setLogin("tester");
        user.setIdUser(25);
        user.setRoleId(2);
        user.setPassword("tester");
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("user")).thenReturn(user);
        String actual = command.execute(request);
        assertEquals(actual, "/WEB-INF/jsp/bill.jsp");
    }
}