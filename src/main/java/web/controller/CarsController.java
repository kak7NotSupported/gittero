package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {


    @GetMapping(value = "/cars")
    public String renderCars(@RequestParam(name = "count", required = false) Integer count, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.addAll(Arrays.asList(new Car(1, "red", false), new Car(2, "blue"), new Car(3, "white"), new Car(4, "white", true), new Car(5, "white", false)));

        if (count != null) {
            model.addAttribute("cars", carList.stream().limit(count).collect(Collectors.toList()));
        } else if (count > 4) {
            model.addAttribute("cars", carList);
        }

        return "cars";
    }

}
