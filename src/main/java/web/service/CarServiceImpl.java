package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    List<Car> carList = new ArrayList<>();

    public CarServiceImpl() {
        carList.addAll(
                Arrays.asList(
                        new Car(1, "red", false),
                        new Car(2, "blue"),
                        new Car(3, "white"),
                        new Car(4, "white", true),
                        new Car(5, "white", false),
                        new Car(6, "black", false)));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count > 4) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
