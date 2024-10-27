package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Nissan", "X-Trail T31", "black", 2013));
        carList.add(new Car("Skoda", "Fabia", "white", 2013));
        carList.add(new Car("Skoda", "Octavia", "grey", 2012));
        carList.add(new Car("Toyota", "Land Cruiser Prado", "black", 2015));
        carList.add(new Car("Volkswagen", "Touareg", "brown", 2018));
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        if (count == 0) {
            return carList;
        }

        return carList
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}