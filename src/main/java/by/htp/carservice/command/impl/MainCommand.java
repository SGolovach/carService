package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return new MainCommand().getPathJsp();
    }
}
