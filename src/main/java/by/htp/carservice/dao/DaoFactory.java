package by.htp.carservice.dao;

import by.htp.carservice.dao.impl.*;
import by.htp.carservice.entity.impl.*;

public class DaoFactory {
    private final BaseDao<UserDetail> userDetailDao = new UserDetailDao();
    private final BaseDao<User> userDao = new UserDao();
    private final BaseDao<Role> roleDao = new RoleDao();
    private final BaseDao<Order> orderDao = new OrderDao();
    private final BaseDao<Invoice> invoiceDao = new InvoiceDao();
    private final BaseDao<Department> departmentDao = new DepartmentDao();
    private final BaseDao<Comment> commentDao = new CommentDao();
    private final BaseDao<Car> carDao = new CarDao();

    private static class DaoFactoryHolder{
        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public static DaoFactory getInstance(){
        return DaoFactoryHolder.INSTANCE;
    }

    public BaseDao<UserDetail> getUserDetailDao() {
        return userDetailDao;
    }

    public BaseDao<User> getUserDao() {
        return userDao;
    }

    public BaseDao<Role> getRoleDao() {
        return roleDao;
    }

    public BaseDao<Order> getOrderDao() {
        return orderDao;
    }

    public BaseDao<Invoice> getInvoiceDao() {
        return invoiceDao;
    }

    public BaseDao<Department> getDepartmentDao() {
        return departmentDao;
    }

    public BaseDao<Comment> getCommentDao() {
        return commentDao;
    }

    public BaseDao<Car> getCarDao() {
        return carDao;
    }
}
