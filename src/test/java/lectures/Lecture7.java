package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class Lecture7 {

    @Test
    public void count() throws Exception {
        long femaleCount = MockData.getPeople().stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female")).count();

        System.out.println(femaleCount);
        assertThat(femaleCount).isNotNull();
    }

    @Test
    public void min() throws Exception {
        /*
         * Gets minimum price of the car, with colour yellow
         */
        double minimumCarPrice = MockData.getCars().stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow")).mapToDouble(Car::getPrice)
                .min().orElse(0);
        System.out.println(minimumCarPrice);
        assertThat(minimumCarPrice).isNotNull();
    }

    @Test
    public void max() throws Exception {
        /*
         * Gets max price of the car, with colour yellow
         */
        double maxCarPrice = MockData.getCars().stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Yellow")).mapToDouble(Car::getPrice)
                .max().getAsDouble();
        System.out.println(maxCarPrice);
        assertThat(maxCarPrice).isNotNull();
    }

    @Test
    public void average() throws Exception {
        // Average of single car mapped to double
        List<Car> cars = MockData.getCars();
        double averageCarPrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(-100);
        System.out.println(averageCarPrice);
        assertThat(averageCarPrice).isNotEqualTo(0);

        List<Car> emptyCarsList = Collections.emptyList();
        double averageCarPriceWhenListEmpty = emptyCarsList.stream().mapToDouble(Car::getPrice)
                .average().orElse(-10);
        System.out.println(averageCarPriceWhenListEmpty);
        assertThat(averageCarPriceWhenListEmpty).isEqualTo(-10);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream().mapToDouble(Car::getPrice).sum();
        // Sum is a very big number hence we need to convert it to big decimal
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum);
        System.out.println(bigDecimalSum);
    }

    @Test
    public void statistics() throws Exception {

        /*
         * SummarStatistics gives you all the sum, average, count in one go you can
         * simply extract what you are looking for from that
         */
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream().mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }

}