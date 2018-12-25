package by.htp.carservice.dao;

import by.htp.carservice.exception.DaoException;

public enum DaoType {
    CAR, COMMENT, DEPARTMENT, INVOICE, ORDER, ROLE, USER, USERDETAIL;

    DaoType() {
    }

    public AbstractDao getDao() throws DaoException {
        AbstractDao dao;
        switch (this) {
            case CAR:
                dao = DaoFactory.getInstance().getCarDao();
                break;
            case COMMENT:
                dao = DaoFactory.getInstance().getCommentDao();
                break;
            case DEPARTMENT:
                dao = DaoFactory.getInstance().getDepartmentDao();
                break;
            case INVOICE:
                dao = DaoFactory.getInstance().getInvoiceDao();
                break;
            case ORDER:
                dao = DaoFactory.getInstance().getOrderDao();
                break;
            case ROLE:
                dao = DaoFactory.getInstance().getRoleDao();
                break;
            case USER:
                dao =  DaoFactory.getInstance().getUserDao();
                break;
            case USERDETAIL:
                dao = DaoFactory.getInstance().getUserDetailDao();
                break;
            default:
                throw new DaoException("This dao does not");
        }
        return dao;
    }
}
