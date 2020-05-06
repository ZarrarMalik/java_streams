package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.Test;

public class Lecture6 {

    final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

    @Test
    public void findAny() throws Exception {
        // This will return any number greater than 5
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer findIntGreaterThanFive = Arrays.stream(numbers).filter(x -> x > 5).findAny().get();
        System.out.println(findIntGreaterThanFive);
        assertThat(findIntGreaterThanFive > 5).isTrue();
    }

    @Test
    public void findFirst() throws Exception {
        // This will find the first number
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer findIntGreaterThanFive = Arrays.stream(numbers).filter(x -> x > 5 && x < 10)
                .findFirst().get();
        System.out.println(findIntGreaterThanFive);
        assertThat(findIntGreaterThanFive > 5).isTrue();
    }
}