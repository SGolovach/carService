package by.htp.carservice.command;

import by.htp.carservice.command.impl.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ActionFactoryTest {

    @DataProvider
    public Object[][] actionCommand() {
        return new Object[][]{
                {"main", new MainCommand()},
                {"login", new LoginCommand()},
                {"logout", new LogOutCommand()},
                {"signup", new SignupCommand()},
                {"comment", new CommentCommand()},
                {"bill", new BillCommand()},
        };
    }

    @Test (dataProvider = "actionCommand")
    public void testDefineCommand(String commandName, Command commandExpected) {
        Command commandActual = ActionFactory.defineCommand(commandName);
        assertEquals(commandActual.getClass(),commandExpected.getClass());
    }
}