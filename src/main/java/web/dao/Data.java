package web.dao;
import web.model.Car;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class Data {
    private List<Car> cars = Arrays.asList(
            new Car("Tesla", 666, "black"),
            new Car("Tesla", 999, "white"),
            new Car("Tesla", 001, "cherry-red"),
            new Car("Tesla", 111, "quick-silver"),
            new Car("Tesla", 222, "pink"));

    public List<Car> getCars() {
        return cars;
    }
}
