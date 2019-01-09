package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class CarPaginateService implements PaginationDataService<Car> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getCarPagination();

    @Override
    public List<Car> paginate(Map<String, String> requestParam) throws CommandException {
        List<Car> carList;
        try {
            carList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return carList;
    }

    @Override
    public List<Car> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Car> carList;
        try {
            carList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return carList;
    }
}
