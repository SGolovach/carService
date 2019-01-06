package by.htp.carservice.service;

import by.htp.carservice.service.impl.*;
import by.htp.carservice.validation.ValidationData;


public class ServiceFactory {
    private final QueryReceiverServiceCar carQueryReceiverService =
            new CarReceiverService();
    private final QueryReceiverServiceComment commentQueryReceiverService =
            new CommentReceiverService();
    private final QueryReceiverServiceDepartment departmentQueryReceiverService =
            new DepartmentReceiverService();
    private final QueryReceiverServiceInvoice invoiceQueryReceiverService =
            new InvoiceReceiverService();
    private final QueryReceiverServiceOrder orderQueryReceiverService =
            new OrderReceiverService();
    private final QueryReceiverServiceRole roleQueryReceiverService =
            new RoleReceiverService();
    private final QueryReceiverServiceUserDetail userDetailQueryReceiverService =
            new UserDetailReceiverService();
    private final QueryReceiverServiceUser userQueryReceiverService =
            new UserReceiverService();
    private final ValidationData validationData = new ValidationData();

    private static class ServiceFactoryHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    public QueryReceiverServiceCar getCarQueryReceiverService() {
        return carQueryReceiverService;
    }

    public QueryReceiverServiceComment getCommentQueryReceiverService() {
        return commentQueryReceiverService;
    }

    public QueryReceiverServiceDepartment getDepartmentQueryReceiverService() {
        return departmentQueryReceiverService;
    }

    public QueryReceiverServiceInvoice getInvoiceQueryReceiverService() {
        return invoiceQueryReceiverService;
    }

    public QueryReceiverServiceOrder getOrderQueryReceiverService() {
        return orderQueryReceiverService;
    }

    public QueryReceiverServiceRole getRoleQueryReceiverService() {
        return roleQueryReceiverService;
    }

    public QueryReceiverServiceUserDetail getUserDetailQueryReceiverService() {
        return userDetailQueryReceiverService;
    }

    public QueryReceiverServiceUser getUserQueryReceiverService() {
        return userQueryReceiverService;
    }

    public ValidationData getValidationData() {
        return validationData;
    }
}
