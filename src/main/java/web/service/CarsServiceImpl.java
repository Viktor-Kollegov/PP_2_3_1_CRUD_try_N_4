package web.service;

import web.dao.CarsDao;
import web.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao;

    public CarsServiceImpl(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> byCount(int count) {
        return carsDao.byCount(count);
    }
}
