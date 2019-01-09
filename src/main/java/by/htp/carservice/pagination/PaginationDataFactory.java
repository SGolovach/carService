package by.htp.carservice.pagination;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.pagination.impl.*;

public class PaginationDataFactory {

    private final PaginationData<Comment> commentPagination = new CommentPaginate();

    private final PaginationData<Car> carPagination = new CarPaginate();

    private final PaginationData<Department> departmentPagination = new DepartmentPaginate();

    private final PaginationData<Invoice> invoicePagination = new InvoicePaginate();

    private final PaginationData<Order> orderPagination = new OrderPaginate();

    private final PaginationData<Role> rolePagination = new RolePaginate();

    private final PaginationData<User> userPagination = new UserPaginate();

    private final PaginationData<UserDetail> userDetailPagination = new UserDetailPaginate();

    private static class PaginationDataFactoryHolder {
        private static final PaginationDataFactory INSTANCE = new PaginationDataFactory();
    }

    public static PaginationDataFactory getInstance() {
        return PaginationDataFactoryHolder.INSTANCE;
    }

    public PaginationData<Comment> getCommentPagination() {
        return commentPagination;
    }

    public PaginationData<Car> getCarPagination() {
        return carPagination;
    }

    public PaginationData<Department> getDepartmentPagination() {
        return departmentPagination;
    }

    public PaginationData<Invoice> getInvoicePagination() {
        return invoicePagination;
    }

    public PaginationData<Order> getOrderPagination() {
        return orderPagination;
    }

    public PaginationData<Role> getRolePagination() {
        return rolePagination;
    }

    public PaginationData<User> getUserPagination() {
        return userPagination;
    }

    public PaginationData<UserDetail> getUserDetailPagination() {
        return userDetailPagination;
    }
}
