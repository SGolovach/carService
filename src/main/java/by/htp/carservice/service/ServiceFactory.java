package by.htp.carservice.service;

import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.service.impl.*;
import by.htp.carservice.service.implpaginate.CommentPaginateService;
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
}
