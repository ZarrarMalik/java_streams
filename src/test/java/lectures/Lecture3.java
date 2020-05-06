package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    
	int minNumber = numbers.stream().min((number1, number2)-> number1 > number2 ? 1 : -1).get();
	// we use .get() because min returns an optional 
	// also min() use comparator which requires two numbers
    assertThat(minNumber == 1);
  }
  
  @Test
  public void minWithComparator() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    /*
     * we use natural order Comparator to get min number
     * There are other Comparators as well like reverse order
     * Type Comparator then . to get the list
     */
	int minNumber = numbers.stream().min(Comparator.naturalOrder()).get();
    assertThat(minNumber == 1);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    int maxNumber = numbers.stream().max(Comparator.naturalOrder()).get();
    assertThat(maxNumber == 99);

  }
}
