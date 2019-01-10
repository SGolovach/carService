package by.htp.carservice.dao;

import by.htp.carservice.dao.impl.*;

/**
 * A factory for creating Dao objects.
 */
public class DaoFactory {
    
    /** The user detail dao. */
    private final DaoUserDetail userDetailDao = new UserDetailDao();
    
    /** The user dao. */
    private final DaoUser userDao = new UserDao();
    
    /** The role dao. */
    private final DaoRole roleDao = new RoleDao();
    
    /** The order dao. */
    private final DaoOrder orderDao = new OrderDao();
    
    /** The invoice dao. */
    private final DaoInvoice invoiceDao = new InvoiceDao();
    
    /** The department dao. */
    private final DaoDepartment departmentDao = new DepartmentDao();
    
    /** The comment dao. */
    private final DaoComment commentDao = new CommentDao();
    
    /** The car dao. */
    private final DaoCar carDao = new CarDao();

    /**
     * The Class DaoFactoryHolder.
     */
    private static class DaoFactoryHolder{
        
        /** The Constant INSTANCE. */
        private static final DaoFactory INSTANCE = new DaoFactory();
    }


    /**
     * Gets the single instance of DaoFactory.
     *
     * @return single instance of DaoFactory
     */
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    /**
     * Gets the user detail dao.
     *
     * @return the user detail dao
     */
    public DaoUserDetail getUserDetailDao() {
        return userDetailDao;
    }

    /**
     * Gets the user dao.
     *
     * @return the user dao
     */
    public DaoUser getUserDao() {
        return userDao;
    }

    /**
     * Gets the role dao.
     *
     * @return the role dao
     */
    public DaoRole getRoleDao() {
        return roleDao;
    }

    /**
     * Gets the order dao.
     *
     * @return the order dao
     */
    public DaoOrder getOrderDao() {
        return orderDao;
    }

    /**
     * Gets the invoice dao.
     *
     * @return the invoice dao
     */
    public DaoInvoice getInvoiceDao() {
        return invoiceDao;
    }

    /**
     * Gets the department dao.
     *
     * @return the department dao
     */
    public DaoDepartment getDepartmentDao() {
        return departmentDao;
    }

    /**
     * Gets the comment dao.
     *
     * @return the comment dao
     */
    public DaoComment getCommentDao() {
        return commentDao;
    }

    /**
     * Gets the car dao.
     *
     * @return the car dao
     */
    public DaoCar getCarDao() {
        return carDao;
    }
}
