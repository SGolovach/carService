package by.htp.carservice.dao;

import by.htp.carservice.dao.impl.*;

public class DaoFactory {
    private final DaoUserDetail userDetailDao = new UserDetailDao();
    private final DaoUser userDao = new UserDao();
    private final DaoRole roleDao = new RoleDao();
    private final DaoOrder orderDao = new OrderDao();
    private final DaoInvoice invoiceDao = new InvoiceDao();
    private final DaoDepartment departmentDao = new DepartmentDao();
    private final DaoComment commentDao = new CommentDao();
    private final DaoCar carDao = new CarDao();

    private static class DaoFactoryHolder{
        private static final DaoFactory INSTANCE = new DaoFactory();
    }


    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    public DaoUserDetail getUserDetailDao() {
        return userDetailDao;
    }

    public DaoUser getUserDao() {
        return userDao;
    }

    public DaoRole getRoleDao() {
        return roleDao;
    }

    public DaoOrder getOrderDao() {
        return orderDao;
    }

    public DaoInvoice getInvoiceDao() {
        return invoiceDao;
    }

    public DaoDepartment getDepartmentDao() {
        return departmentDao;
    }

    public DaoComment getCommentDao() {
        return commentDao;
    }

    public DaoCar getCarDao() {
        return carDao;
    }
}
