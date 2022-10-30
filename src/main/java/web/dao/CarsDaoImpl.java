package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarsDaoImpl implements CarsDao {

    private Data data;

    public CarsDaoImpl(Data data) {
        this.data = data;
    }

    @Override
    public List<Car> listCars() {
        return data.getCars();
    }

    @Override
    public List<Car> byCount(int count) {
        return data.getCars()
                .stream()
                .limit(count)
                .toList();
    }
}
