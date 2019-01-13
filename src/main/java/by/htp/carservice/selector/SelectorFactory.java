package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.selector.impl.*;
import by.htp.carservice.selector.impl.CommentPaginateSelector;
import by.htp.carservice.validation.ValidationData;


public class SelectorFactory {
    private final SelectorCar carSelector = new CarSelector();
    private final SelectorComment commentSelector = new CommentSelector();
    private final SelectorDepartment departmentSelector = new DepartmentSelector();
    private final SelectorInvoice invoiceSelector = new InvoiceSelector();
    private final SelectorOrder orderSelector = new OrderSelector();
    private final SelectorRole roleSelector = new RoleSelector();
    private final SelectorUserDetail userDetailSelector = new UserDetailSelector();
    private final SelectorUser userSelector = new UserSelector();
    private final ValidationData validationData = new ValidationData();
    private final PaginationDataSelector<Comment> commentPaginationDataSelector =
            new CommentPaginateSelector();

    private final PaginationDataSelector<Car> carPaginationDataSelector =
            new CarPaginateSelector();

    private final PaginationDataSelector<Department> departmentPaginationDataSelector =
            new DepartmentPaginateSelector();

    private final PaginationDataSelector<Invoice> invoicePaginationDataSelector =
            new InvoicePaginateSelector();

    private final PaginationDataSelector<Order> orderPaginationDataSelector =
            new OrderPaginateSelector();

    private final PaginationDataSelector<Role> rolePaginationDataSelector =
            new RolePaginateSelector();

    private final PaginationDataSelector<UserDetail> userDetailPaginationDataSelector =
            new UserDetailPaginateSelector();

    private final PaginationDataSelector<User> userPaginationDataSelector =
            new UserPaginateSelector();

    private static class ServiceFactoryHolder {
        private static final SelectorFactory INSTANCE = new SelectorFactory();
    }

    public static SelectorFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    public SelectorCar getCarSelector() {
        return carSelector;
    }

    public SelectorComment getCommentSelector() {
        return commentSelector;
    }

    public SelectorDepartment getDepartmentSelector() {
        return departmentSelector;
    }

    public SelectorInvoice getInvoiceSelector() {
        return invoiceSelector;
    }

    public SelectorOrder getOrderSelector() {
        return orderSelector;
    }

    public SelectorRole getRoleSelector() {
        return roleSelector;
    }

    public SelectorUserDetail getUserDetailSelector() {
        return userDetailSelector;
    }

    public SelectorUser getUserSelector() {
        return userSelector;
    }

    public ValidationData getValidationData() {
        return validationData;
    }

    public PaginationDataSelector<Comment> getCommentPaginationDataSelector() {
        return commentPaginationDataSelector;
    }

    public PaginationDataSelector<Car> getCarPaginationDataSelector() {
        return carPaginationDataSelector;
    }

    public PaginationDataSelector<Department> getDepartmentPaginationDataSelector() {
        return departmentPaginationDataSelector;
    }

    public PaginationDataSelector<Invoice> getInvoicePaginationDataSelector() {
        return invoicePaginationDataSelector;
    }

    public PaginationDataSelector<Order> getOrderPaginationDataSelector() {
        return orderPaginationDataSelector;
    }

    public PaginationDataSelector<Role> getRolePaginationDataSelector() {
        return rolePaginationDataSelector;
    }

    public PaginationDataSelector<UserDetail> getUserDetailPaginationDataSelector() {
        return userDetailPaginationDataSelector;
    }

    public PaginationDataSelector<User> getUserPaginationDataSelector() {
        return userPaginationDataSelector;
    }
}
