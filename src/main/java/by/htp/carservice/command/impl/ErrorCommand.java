package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;

public class ErrorCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return new ErrorCommand().getPathJsp();
    }
}
