package lectures;


import com.google.common.collect.Lists;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

    @Test
    public void withoutFlatMap() throws Exception {
        // Print the names from the arrayListOfNames in a single list
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> nameOfPeople = new ArrayList<>();
        for (List<String> names : arrayListOfNames) {
            for (String name : names) {
                nameOfPeople.add(name);
            }
        }
        System.out.println(nameOfPeople);
    }

    @Test
    public void withFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = arrayListOfNames.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(names);
        assertThat(names).isNotEmpty();
    }
}