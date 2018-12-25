package by.htp.carservice.dao;

import by.htp.carservice.dao.impldao.*;
import by.htp.carservice.entity.impl.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DaoFactory {
    private static DaoFactory instance;
    private static ReentrantLock lockDaoFactory = new ReentrantLock();
    private static AtomicBoolean createDaoFactory = new AtomicBoolean(false);
    private final AbstractDao<UserDetail> userDetailDao = new UserDetailDao();
    private final AbstractDao<User> userDao = new UserDao();
    private final AbstractDao<Role> roleDao = new RoleDao();
    private final AbstractDao<Order> orderDao = new OrderDao();
    private final AbstractDao<Invoice> invoiceDao = new InvoiceDao();
    private final AbstractDao<Department> departmentDao = new DepartmentDao();
    private final AbstractDao<Comment> commentDao = new CommentDao();
    private final AbstractDao<Car> carDao = new CarDao();

    public static DaoFactory getInstance() {
        if (!createDaoFactory.get()) {
            try {
                lockDaoFactory.lock();
                if (instance == null) {
                    instance = new DaoFactory();
                    createDaoFactory.set(true);
                }
            } finally {
                lockDaoFactory.unlock();
            }
        }
        return instance;
    }

    public AbstractDao<UserDetail> getUserDetailDao() {
        return userDetailDao;
    }

    public AbstractDao<User> getUserDao() {
        return userDao;
    }

    public AbstractDao<Role> getRoleDao() {
        return roleDao;
    }

    public AbstractDao<Order> getOrderDao() {
        return orderDao;
    }

    public AbstractDao<Invoice> getInvoiceDao() {
        return invoiceDao;
    }

    public AbstractDao<Department> getDepartmentDao() {
        return departmentDao;
    }

    public AbstractDao<Comment> getCommentDao() {
        return commentDao;
    }

    public AbstractDao<Car> getCarDao() {
        return carDao;
    }
}
