package lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class Lecture8 {

    @Test
    public void simpleGrouping() throws Exception {
        // Collectors.groupingBy returns a Map
        Map<String, List<Car>> groupByCarMake = MockData.getCars().stream()
                .collect(Collectors.groupingBy(Car::getMake));

        // Map uses a bi consumer meaning two inputs
        // One is string and the other is a list
        groupByCarMake.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        // We want to find out how many times names are repeated
        ArrayList<String> names = Lists.newArrayList("John", "John", "Mariam", "Alex", "Mohammado",
                "Mohammado", "Vincent", "Alex", "Alex");
        /*
         * Here we use Function.identity() for the name and Collectors.counting() for
         * actual count
         */
        Map<String, Long> groupByName = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        groupByName.forEach((name, occurance) -> {
            System.out.println(name + "" + "==>" + occurance);
        });
    }
}