package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class Lecture9 {

    @Test
    public void reduce() throws Exception {
        Integer[] integers = { 1, 2, 3, 4, 99, 100, 121, 1302, 199 };
        // we use reduce with integer identity which is start of the stream
        // 0 in this case and add the previous number to the next
        int sumOfGivenArray = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(sumOfGivenArray);
        assertThat(sumOfGivenArray).isNotNull().isGreaterThanOrEqualTo(1831);

        // Easier way to do this is via a built in function
        int sumWithIntegerMethod = Arrays.stream(integers).reduce(0, (Integer::sum));
        System.out.println(sumWithIntegerMethod);
        assertThat(sumWithIntegerMethod).isNotNull().isGreaterThanOrEqualTo(1831);
    }
}