package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.*;
import by.htp.carservice.selector.impl.*;
import by.htp.carservice.selector.impl.CommentPaginateSelector;
import by.htp.carservice.validation.ValidationData;


/**
 * A factory for creating Selector objects.
 */
public class SelectorFactory {
    
    /** The car selector. */
    private final SelectorCar carSelector = new CarSelector();
    
    /** The comment selector. */
    private final SelectorComment commentSelector = new CommentSelector();
    
    /** The department selector. */
    private final SelectorDepartment departmentSelector = new DepartmentSelector();
    
    /** The invoice selector. */
    private final SelectorInvoice invoiceSelector = new InvoiceSelector();
    
    /** The order selector. */
    private final SelectorOrder orderSelector = new OrderSelector();
    
    /** The role selector. */
    private final SelectorRole roleSelector = new RoleSelector();
    
    /** The user detail selector. */
    private final SelectorUserDetail userDetailSelector = new UserDetailSelector();
    
    /** The user selector. */
    private final SelectorUser userSelector = new UserSelector();
    
    /** The validation data. */
    private final ValidationData validationData = new ValidationData();
    
    /** The comment pagination data selector. */
    private final PaginationDataSelector<Comment> commentPaginationDataSelector =
            new CommentPaginateSelector();

    /** The car pagination data selector. */
    private final PaginationDataSelector<Car> carPaginationDataSelector =
            new CarPaginateSelector();

    /** The department pagination data selector. */
    private final PaginationDataSelector<Department> departmentPaginationDataSelector =
            new DepartmentPaginateSelector();

    /** The invoice pagination data selector. */
    private final PaginationDataSelector<Invoice> invoicePaginationDataSelector =
            new InvoicePaginateSelector();

    /** The order pagination data selector. */
    private final PaginationDataSelector<Order> orderPaginationDataSelector =
            new OrderPaginateSelector();

    /** The role pagination data selector. */
    private final PaginationDataSelector<Role> rolePaginationDataSelector =
            new RolePaginateSelector();

    /** The user detail pagination data selector. */
    private final PaginationDataSelector<UserDetail> userDetailPaginationDataSelector =
            new UserDetailPaginateSelector();

    /** The user pagination data selector. */
    private final PaginationDataSelector<User> userPaginationDataSelector =
            new UserPaginateSelector();

    /**
     * The Class ServiceFactoryHolder.
     */
    private static class ServiceFactoryHolder {
        
        /** The Constant INSTANCE. */
        private static final SelectorFactory INSTANCE = new SelectorFactory();
    }

    /**
     * Gets the single instance of SelectorFactory.
     *
     * @return single instance of SelectorFactory
     */
    public static SelectorFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    /**
     * Gets the car selector.
     *
     * @return the car selector
     */
    public SelectorCar getCarSelector() {
        return carSelector;
    }

    /**
     * Gets the comment selector.
     *
     * @return the comment selector
     */
    public SelectorComment getCommentSelector() {
        return commentSelector;
    }

    /**
     * Gets the department selector.
     *
     * @return the department selector
     */
    public SelectorDepartment getDepartmentSelector() {
        return departmentSelector;
    }

    /**
     * Gets the invoice selector.
     *
     * @return the invoice selector
     */
    public SelectorInvoice getInvoiceSelector() {
        return invoiceSelector;
    }

    /**
     * Gets the order selector.
     *
     * @return the order selector
     */
    public SelectorOrder getOrderSelector() {
        return orderSelector;
    }

    /**
     * Gets the role selector.
     *
     * @return the role selector
     */
    public SelectorRole getRoleSelector() {
        return roleSelector;
    }

    /**
     * Gets the user detail selector.
     *
     * @return the user detail selector
     */
    public SelectorUserDetail getUserDetailSelector() {
        return userDetailSelector;
    }

    /**
     * Gets the user selector.
     *
     * @return the user selector
     */
    public SelectorUser getUserSelector() {
        return userSelector;
    }

    /**
     * Gets the validation data.
     *
     * @return the validation data
     */
    public ValidationData getValidationData() {
        return validationData;
    }

    /**
     * Gets the comment pagination data selector.
     *
     * @return the comment pagination data selector
     */
    public PaginationDataSelector<Comment> getCommentPaginationDataSelector() {
        return commentPaginationDataSelector;
    }

    /**
     * Gets the car pagination data selector.
     *
     * @return the car pagination data selector
     */
    public PaginationDataSelector<Car> getCarPaginationDataSelector() {
        return carPaginationDataSelector;
    }

    /**
     * Gets the department pagination data selector.
     *
     * @return the department pagination data selector
     */
    public PaginationDataSelector<Department> getDepartmentPaginationDataSelector() {
        return departmentPaginationDataSelector;
    }

    /**
     * Gets the invoice pagination data selector.
     *
     * @return the invoice pagination data selector
     */
    public PaginationDataSelector<Invoice> getInvoicePaginationDataSelector() {
        return invoicePaginationDataSelector;
    }

    /**
     * Gets the order pagination data selector.
     *
     * @return the order pagination data selector
     */
    public PaginationDataSelector<Order> getOrderPaginationDataSelector() {
        return orderPaginationDataSelector;
    }

    /**
     * Gets the role pagination data selector.
     *
     * @return the role pagination data selector
     */
    public PaginationDataSelector<Role> getRolePaginationDataSelector() {
        return rolePaginationDataSelector;
    }

    /**
     * Gets the user detail pagination data selector.
     *
     * @return the user detail pagination data selector
     */
    public PaginationDataSelector<UserDetail> getUserDetailPaginationDataSelector() {
        return userDetailPaginationDataSelector;
    }

    /**
     * Gets the user pagination data selector.
     *
     * @return the user pagination data selector
     */
    public PaginationDataSelector<User> getUserPaginationDataSelector() {
        return userPaginationDataSelector;
    }
}
