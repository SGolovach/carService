package by.htp.carservice.service;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.service.impl.*;

public class ServiceFactory {

    private final DaoService<Car> carDaoService = new CarDaoService();
    private final DaoService<Comment> commentDaoService = new CommentDaoService();
    private final DaoService<Department> departmentDaoService = new DepartmentDaoService();
    private final DaoService<Invoice> invoiceDaoService = new InvoiceDaoService();
    private final DaoService<Order> orderDaoService = new OrderDaoService();
    private final DaoService<Role> roleDaoService = new RoleDaoService();
    private final DaoService<User> userDaoService = new UserDaoService();
    private final DaoService<UserDetail> userDetailDaoService = new UserDetailDaoService();

    private static class  ServiceFactoryHolder{
        private final static ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory getInstance(){
        return ServiceFactoryHolder.INSTANCE;
    }

    public DaoService<Car> getCarDaoService() {
        return carDaoService;
    }

    public DaoService<Comment> getCommentDaoService() {
        return commentDaoService;
    }

    public DaoService<Department> getDepartmentDaoService() {
        return departmentDaoService;
    }

    public DaoService<Invoice> getInvoiceDaoService() {
        return invoiceDaoService;
    }

    public DaoService<Order> getOrderDaoService() {
        return orderDaoService;
    }

    public DaoService<Role> getRoleDaoService() {
        return roleDaoService;
    }

    public DaoService<User> getUserDaoService() {
        return userDaoService;
    }

    public DaoService<UserDetail> getUserDetailDaoService() {
        return userDetailDaoService;
    }
}
