package by.htp.carservice.transaction;

import by.htp.carservice.transaction.imlpreceiver.*;

public class QueryReceiverFactory {
    private final QueryReceiverCar carQueryReceiver = new CarReceiver();
    private final QueryReceiverComment commentQueryReceiver = new CommentReceiver();
    private final QueryReceiverDepartment departmentQueryReceiver = new DepartmentReceiver();
    private final QueryReceiverInvoice invoiceQueryReceiver = new InvoiceReceiver();
    private final QueryReceiverOrder orderQueryReceiver = new OrderReceiver();
    private final QueryReceiverRole roleQueryReceiver = new RoleReceiver();
    private final QueryReceiverUserDetail userDetailQueryReceiver = new UserDetailReceiver();
    private final QueryReceiverUser userQueryReceiver = new UserReceiver();

    private static class QueryReceiverFactoryHolder {
        private static final QueryReceiverFactory INSTANCE = new QueryReceiverFactory();
    }

    public static QueryReceiverFactory getInstance() {
        return QueryReceiverFactoryHolder.INSTANCE;
    }

    public QueryReceiverCar getCarQueryReceiver() {
        return carQueryReceiver;
    }

    public QueryReceiverComment getCommentQueryReceiver() {
        return commentQueryReceiver;
    }

    public QueryReceiverDepartment getDepartmentQueryReceiver() {
        return departmentQueryReceiver;
    }

    public QueryReceiverInvoice getInvoiceQueryReceiver() {
        return invoiceQueryReceiver;
    }

    public QueryReceiverOrder getOrderQueryReceiver() {
        return orderQueryReceiver;
    }

    public QueryReceiverRole getRoleQueryReceiver() {
        return roleQueryReceiver;
    }

    public QueryReceiverUserDetail getUserDetailQueryReceiver() {
        return userDetailQueryReceiver;
    }

    public QueryReceiverUser getUserQueryReceiver() {
        return userQueryReceiver;
    }
}
