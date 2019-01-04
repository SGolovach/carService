package by.htp.carservice.main;

import by.htp.carservice.connectiondb.ConnectionPool;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.transaction.imlpreceiver.UserReceiver;

public class Runner {
    public static void main(String[] args) throws CommandException, ServiceException {

        ServiceFactory factory = ServiceFactory.getInstance();

        System.out.println(factory.getUserQueryReceiverService().takeAllQuery());

        ConnectionPool.getInstance().closeConnectionPool();


    }
}
