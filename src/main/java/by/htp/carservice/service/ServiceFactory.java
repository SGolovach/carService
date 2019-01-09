package by.htp.carservice.service;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.service.impl.*;
import by.htp.carservice.service.impl.CommentPaginateService;
import by.htp.carservice.validation.ValidationData;


public class ServiceFactory {
    private final QueryServiceCar carQueryService =
            new CarService();
    private final QueryServiceComment commentQueryService =
            new CommentService();
    private final QueryServiceDepartment departmentQueryService =
            new DepartmentService();
    private final QueryServiceInvoice invoiceQueryService =
            new InvoiceService();
    private final QueryServiceOrder orderQueryService =
            new OrderService();
    private final QueryServiceRole roleQueryService =
            new RoleService();
    private final QueryServiceUserDetail userDetailQueryService =
            new UserDetailService();
    private final QueryServiceUser userQueryService =
            new UserService();
    private final ValidationData validationData = new ValidationData();
    private final PaginationDataService<Comment> commentPaginationDataService =
            new CommentPaginateService();

    private final PaginationDataService<Car> carPaginationDataService =
            new CarPaginateService();

    private final PaginationDataService<Department> departmentPaginationDataService =
            new DepartmentPaginateService();

    private final PaginationDataService<Invoice> invoicePaginationDataService =
            new InvoicePaginateService();

    private final PaginationDataService<Order> orderPaginationDataService =
            new OrderPaginateService();

    private final PaginationDataService<Role> rolePaginationDataService =
            new RolePaginateService();

    private final PaginationDataService<UserDetail> userDetailPaginationDataService =
            new UserDetailPaginateService();

    private final PaginationDataService<User> userPaginationDataService =
            new UserPaginateService();

    private static class ServiceFactoryHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    public QueryServiceCar getCarQueryService() {
        return carQueryService;
    }

    public QueryServiceComment getCommentQueryService() {
        return commentQueryService;
    }

    public QueryServiceDepartment getDepartmentQueryService() {
        return departmentQueryService;
    }

    public QueryServiceInvoice getInvoiceQueryService() {
        return invoiceQueryService;
    }

    public QueryServiceOrder getOrderQueryService() {
        return orderQueryService;
    }

    public QueryServiceRole getRoleQueryService() {
        return roleQueryService;
    }

    public QueryServiceUserDetail getUserDetailQueryService() {
        return userDetailQueryService;
    }

    public QueryServiceUser getUserQueryService() {
        return userQueryService;
    }

    public ValidationData getValidationData() {
        return validationData;
    }

    public PaginationDataService<Comment> getCommentPaginationDataService() {
        return commentPaginationDataService;
    }

    public PaginationDataService<Car> getCarPaginationDataService() {
        return carPaginationDataService;
    }

    public PaginationDataService<Department> getDepartmentPaginationDataService() {
        return departmentPaginationDataService;
    }

    public PaginationDataService<Invoice> getInvoicePaginationDataService() {
        return invoicePaginationDataService;
    }

    public PaginationDataService<Order> getOrderPaginationDataService() {
        return orderPaginationDataService;
    }

    public PaginationDataService<Role> getRolePaginationDataService() {
        return rolePaginationDataService;
    }

    public PaginationDataService<UserDetail> getUserDetailPaginationDataService() {
        return userDetailPaginationDataService;
    }

    public PaginationDataService<User> getUserPaginationDataService() {
        return userPaginationDataService;
    }
}
