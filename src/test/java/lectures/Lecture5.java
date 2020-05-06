package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import mockdata.MockData;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();
        Predicate<Car> carPredicate = car -> car.getPrice() > 10000;
        List<Car> priceRange = cars.stream().filter(carPredicate).limit(25)
                .collect(Collectors.toList());

        priceRange.forEach(System.out::println);
        System.out.println(priceRange.size());

        assertThat(priceRange).isNotEmpty().hasSize(25);
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        // tranforming from person to PersonDTO
        // Which has only three fields
        List<Person> people = MockData.getPeople();
        List<PersonDTO> peopleDTOList = people.stream().map(person -> {
            PersonDTO personDto = new PersonDTO(person.getId(), person.getFirstName(),
                    person.getAge());
            return personDto;
        }).collect(Collectors.toList());

        peopleDTOList.forEach(System.out::println);
        System.out.println(peopleDTOList.size());
        assertThat(peopleDTOList.size() == people.size()).isTrue();
    }

    @Test
    public void ourFirstMappingWithReference() throws Exception {
        // transform from one data type to another
        // tranforming from person to PersonDTO
        // Which has only three fields
        // PersonDTO has a method called map which converts person to PersonDTO
        // As mentioned above
        List<Person> people = MockData.getPeople();
        List<PersonDTO> peopleDTOList = people.stream().map(PersonDTO::map)
                .collect(Collectors.toList());

        peopleDTOList.forEach(System.out::println);
        System.out.println(peopleDTOList.size());
        assertThat(peopleDTOList.size() == people.size()).isTrue();
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        // Map converts Car price into double, returns a single entity
        ImmutableList<Car> cars = MockData.getCars();
        Double averagePrice = cars.stream().mapToDouble(price -> {
            Double carPrice = price.getPrice();
            return carPrice;
        }).average().getAsDouble();
        System.out.println(averagePrice);

        // 2nd way
        Double averagePriceSecondWay = cars.stream().mapToDouble(value -> value.getPrice())
                .average().orElse(0);
        System.out.println(averagePriceSecondWay);

        // Third way
        Double averagePriceThirdWay = cars.stream().mapToDouble(Car::getPrice).average()
                .getAsDouble();
        System.out.println(averagePriceThirdWay);

        assertThat(Double.compare(averagePrice, averagePriceSecondWay)).isEqualTo(0);
        assertThat(Double.compare(averagePriceSecondWay, averagePriceThirdWay)).isEqualTo(0);
    }

    @Test
    public void test() throws Exception {

        MockData.getCars().forEach(System.out::println);
    }
}