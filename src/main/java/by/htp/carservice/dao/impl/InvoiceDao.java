package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Invoice;

import java.util.List;

public class InvoiceDao implements BaseDao<Invoice> {
    @Override
    public boolean save(Invoice entity) {
        return false;
    }

    @Override
    public boolean update(Invoice entity) {
        return false;
    }

    @Override
    public boolean delete(Invoice entity) {
        return false;
    }

    @Override
    public Invoice take(long id) {
        return null;
    }

    @Override
    public List<Invoice> takeAll(String condition) {
        return null;
    }
}
