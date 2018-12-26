package by.htp.carservice.transaction;

import by.htp.carservice.transaction.imlpreceiver.*;
import by.htp.carservice.entity.impl.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class QueryReceiverFactory {
    private static QueryReceiverFactory instance;
    private static ReentrantLock lockQueryReceiverFactory = new ReentrantLock();
    private static AtomicBoolean createQueryReceiverFactory = new AtomicBoolean(false);
    private final QueryReceiver<Car> carQueryReceiver = new CarReceiver();
    private final QueryReceiver<Comment> commentQueryReceiver = new CommentReceiver();
    private final QueryReceiver<Department> departmentQueryReceiver = new DepartmentReceiver();
    private final QueryReceiver<Invoice> invoiceQueryReceiver = new InvoiceReceiver();
    private final QueryReceiver<Order> orderQueryReceiver = new OrderReceiver();
    private final QueryReceiver<Role> roleQueryReceiver = new RoleReceiver();
    private final QueryReceiver<UserDetail> userDetailQueryReceiver = new UserDetailReceiver();
    private final QueryReceiver<User> userQueryReceiver = new UserReceiver();

    public static QueryReceiverFactory getInstance() {
        if (!createQueryReceiverFactory.get()) {
            try {
                lockQueryReceiverFactory.lock();
                if (instance == null) {
                    instance = new QueryReceiverFactory();
                    createQueryReceiverFactory.set(true);
                }
            } finally {
                lockQueryReceiverFactory.unlock();
            }
        }
        return instance;
    }

    public QueryReceiver<Car> getCarQueryReceiver() {
        return carQueryReceiver;
    }

    public QueryReceiver<Comment> getCommentQueryReceiver() {
        return commentQueryReceiver;
    }

    public QueryReceiver<Department> getDepartmentQueryReceiver() {
        return departmentQueryReceiver;
    }

    public QueryReceiver<Invoice> getInvoiceQueryReceiver() {
        return invoiceQueryReceiver;
    }

    public QueryReceiver<Order> getOrderQueryReceiver() {
        return orderQueryReceiver;
    }

    public QueryReceiver<Role> getRoleQueryReceiver() {
        return roleQueryReceiver;
    }

    public QueryReceiver<UserDetail> getUserDetailQueryReceiver() {
        return userDetailQueryReceiver;
    }

    public QueryReceiver<User> getUserQueryReceiver() {
        return userQueryReceiver;
    }
}
