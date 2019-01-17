package by.htp.carservice.pagination;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.pagination.impl.*;

/**
 * A factory for creating PaginationData objects.
 */
public class PaginationDataFactory {

    /** The comment pagination. */
    private final PaginationData<Comment> commentPagination = new CommentPaginate();

    /** The car pagination. */
    private final PaginationData<Car> carPagination = new CarPaginate();

    /** The department pagination. */
    private final PaginationData<Department> departmentPagination = new DepartmentPaginate();

    /** The invoice pagination. */
    private final PaginationData<Invoice> invoicePagination = new InvoicePaginate();

    /** The order pagination. */
    private final PaginationData<Order> orderPagination = new OrderPaginate();

    /** The role pagination. */
    private final PaginationData<Role> rolePagination = new RolePaginate();

    /** The user pagination. */
    private final PaginationData<User> userPagination = new UserPaginate();

    /** The user detail pagination. */
    private final PaginationData<UserDetail> userDetailPagination = new UserDetailPaginate();

    /**
     * The Class PaginationDataFactoryHolder.
     */
    private static class PaginationDataFactoryHolder {
        
        /** The Constant INSTANCE. */
        private static final PaginationDataFactory INSTANCE = new PaginationDataFactory();
    }

    /**
     * Gets the single instance of PaginationDataFactory.
     *
     * @return single instance of PaginationDataFactory
     */
    public static PaginationDataFactory getInstance() {
        return PaginationDataFactoryHolder.INSTANCE;
    }

    /**
     * Gets the comment pagination.
     *
     * @return the comment pagination
     */
    public PaginationData<Comment> getCommentPagination() {
        return commentPagination;
    }

    /**
     * Gets the car pagination.
     *
     * @return the car pagination
     */
    public PaginationData<Car> getCarPagination() {
        return carPagination;
    }

    /**
     * Gets the department pagination.
     *
     * @return the department pagination
     */
    public PaginationData<Department> getDepartmentPagination() {
        return departmentPagination;
    }

    /**
     * Gets the invoice pagination.
     *
     * @return the invoice pagination
     */
    public PaginationData<Invoice> getInvoicePagination() {
        return invoicePagination;
    }

    /**
     * Gets the order pagination.
     *
     * @return the order pagination
     */
    public PaginationData<Order> getOrderPagination() {
        return orderPagination;
    }

    /**
     * Gets the role pagination.
     *
     * @return the role pagination
     */
    public PaginationData<Role> getRolePagination() {
        return rolePagination;
    }

    /**
     * Gets the user pagination.
     *
     * @return the user pagination
     */
    public PaginationData<User> getUserPagination() {
        return userPagination;
    }

    /**
     * Gets the user detail pagination.
     *
     * @return the user detail pagination
     */
    public PaginationData<UserDetail> getUserDetailPagination() {
        return userDetailPagination;
    }
}
