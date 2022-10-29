package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarsController {
    List<Car> cars = Arrays.asList(
            new Car("Tesla", 666, "black"),
            new Car("Tesla", 999, "white"),
            new Car("Tesla", 001, "cherry-red"),
            new Car("Tesla", 111, "quick-silver"),
            new Car("Tesla", 222, "pink"));

    @GetMapping(value = "/cars")
    public String getCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        if (count == null) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", cars.stream().limit(count).toList());
        }
        return "cars";
    }
}