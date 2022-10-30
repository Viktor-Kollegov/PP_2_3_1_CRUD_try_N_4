package web.service;

import web.model.Car;

import java.util.List;

public interface CarsService {

    List<Car> byCount(int count);

}
