package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class InvoiceDaoService implements DaoService<Invoice> {
    private final BaseDao<Invoice> dao =DaoFactory.getInstance().getInvoiceDao();

    @Override
    public boolean save(Invoice entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Invoice entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Invoice entity) {
        return dao.delete(entity);
    }

    @Override
    public Invoice take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Invoice> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
