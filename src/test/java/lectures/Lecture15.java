package lectures;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import beans.Car;

public class Lecture15 {
    @Test
    public void testAllMatchStreams() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(262, "Scion", "xB", "Goldenrod", 2012, 55778.37));
        carList.add(new Car(265, "Oldsmobile", "Cutlass Cruiser", "Blue", 1994, 43755.08));
        carList.add(new Car(264, "Lamborghini", "Gallardo", "Puce", 2005, 27074.24));

        Predicate<? super Car> predicate = price -> price.getPrice() > 4000;
        boolean carPrice = carList.stream().allMatch(predicate);

        assertTrue(carPrice);
    }

    @Test
    public void testAnyMatch() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(262, "Scion", "xB", "Goldenrod", 2012, 55778.37));
        carList.add(new Car(265, "Oldsmobile", "Cutlass Cruiser", "Blue", 1994, 43755.08));
        carList.add(new Car(264, "Lamborghini", "Gallardo", "Puce", 2005, 27074.24));

        // starts with should match the exact string
        Predicate<? super Car> predicate = color -> color.getColor().startsWith("Blue");
        boolean carColor = carList.stream().anyMatch(predicate);

        assertTrue(carColor);
    }

    @Test
    public void testNoneMatch() throws Exception {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(262, "Scion", "xB", "Goldenrod", 2012, 55778.37));
        carList.add(new Car(265, "Oldsmobile", "Cutlass Cruiser", "Blue", 1994, 43755.08));
        carList.add(new Car(264, "Lamborghini", "Gallardo", "Puce", 2005, 27074.24));

        boolean carMake = carList.stream().noneMatch(make -> make.getMake().startsWith("Toyota"));

        assertTrue(carMake);
    }

    @Test
    public void testAddAll() throws Exception {
        List<Car> carListOne = new ArrayList<>();
        carListOne.add(new Car(262, "Scion", "xB", "Goldenrod", 2012, 55778.37));
        carListOne.add(new Car(265, "Oldsmobile", "Cutlass Cruiser", "Blue", 1994, 43755.08));
        carListOne.add(new Car(264, "Lamborghini", "Gallardo", "Puce", 2005, 27074.24));

        // addAll is used to append all of the elements of argument collection tot the
        // list at the end
        List<Car> carListTwo = new ArrayList<>();
        carListTwo.add(new Car(988, "Volkswagen", "Passat", "Purple", 1987, 88405.64));
        carListTwo.add(new Car(989, "Chevrolet", "Aveo", "Mauv", 2006, 56011.19));

        carListTwo.addAll(2, carListOne);
        System.out.println(carListTwo);
        assertTrue(carListTwo.size() > 4);
    }
}