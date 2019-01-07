package by.htp.carservice.transaction;

import by.htp.carservice.transaction.imlp.*;

public class QueryFactory {
    private final QueryCar carQuery = new CarTransaction();
    private final QueryComment commentQuery = new CommentTransaction();
    private final QueryDepartment departmentQuery = new DepartmentTransaction();
    private final QueryInvoice invoiceQuery = new InvoiceTransaction();
    private final QueryOrder orderQuery = new OrderTransaction();
    private final QueryRole roleQuery = new RoleTransaction();
    private final QueryUserDetail userDetailQuery = new UserDetailTransaction();
    private final QueryUser userQuery = new UserTransaction();

    private static class QueryReceiverFactoryHolder {
        private static final QueryFactory INSTANCE = new QueryFactory();
    }

    public static QueryFactory getInstance() {
        return QueryReceiverFactoryHolder.INSTANCE;
    }

    public QueryCar getCarQuery() {
        return carQuery;
    }

    public QueryComment getCommentQuery() {
        return commentQuery;
    }

    public QueryDepartment getDepartmentQuery() {
        return departmentQuery;
    }

    public QueryInvoice getInvoiceQuery() {
        return invoiceQuery;
    }

    public QueryOrder getOrderQuery() {
        return orderQuery;
    }

    public QueryRole getRoleQuery() {
        return roleQuery;
    }

    public QueryUserDetail getUserDetailQuery() {
        return userDetailQuery;
    }

    public QueryUser getUserQuery() {
        return userQuery;
    }
}
