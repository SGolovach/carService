package by.htp.carservice.service;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.service.impl.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceFactory {
    private static ServiceFactory instance;
    private static ReentrantLock lockServiceFactory = new ReentrantLock();
    private static AtomicBoolean createServiceFactory = new AtomicBoolean(false);
    private final QueryReceiverService<Car> carQueryReceiverService =
            new CarReceiverService();
    private final QueryReceiverService<Comment> commentQueryReceiverService =
            new CommentReceiverService();
    private final QueryReceiverService<Department> departmentQueryReceiverService =
            new DepartmentReceiverService();
    private final QueryReceiverService<Invoice> invoiceQueryReceiverService =
            new InvoiceReceiverService();
    private final QueryReceiverService<Order> orderQueryReceiverService =
            new OrderReceiverService();
    private final QueryReceiverService<Role> roleQueryReceiverService =
            new RoleReceiverService();
    private final QueryReceiverService<UserDetail> userDetailQueryReceiverService =
            new UserDetailReceiverService();
    private final QueryReceiverService<User> userQueryReceiverService =
            new UserReceiverService();

    public static ServiceFactory getInstance() {

                    instance = new ServiceFactory();

        return instance;
    }

    public QueryReceiverService<Car> getCarQueryReceiverService() {
        return carQueryReceiverService;
    }

    public QueryReceiverService<Comment> getCommentQueryReceiverService() {
        return commentQueryReceiverService;
    }

    public QueryReceiverService<Department> getDepartmentQueryReceiverService() {
        return departmentQueryReceiverService;
    }

    public QueryReceiverService<Invoice> getInvoiceQueryReceiverService() {
        return invoiceQueryReceiverService;
    }

    public QueryReceiverService<Order> getOrderQueryReceiverService() {
        return orderQueryReceiverService;
    }

    public QueryReceiverService<Role> getRoleQueryReceiverService() {
        return roleQueryReceiverService;
    }

    public QueryReceiverService<UserDetail> getUserDetailQueryReceiverService() {
        return userDetailQueryReceiverService;
    }

    public QueryReceiverService<User> getUserQueryReceiverService() {
        return userQueryReceiverService;
    }
}
