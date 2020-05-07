package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }

    @Test
    public void TestUnderstandingCollectSecondWay() throws Exception {
        // Collectors.tolist described further
        // Use three constructors with supplier, accumulatro and combiner
        // Does the same job as the above test case
        List<String> emails = MockData.getPeople().stream().map(Person::getEmail).collect(
                () -> new ArrayList<>(), (list, item) -> list.add(item),
                (list1, list2) -> list1.addAll(list2));

        emails.forEach(System.out::println);
    }
    
    @Test
    public void TestUnderstandingCollectThirdWay() throws Exception {
        // Collectors.tolist described further
        // Use three constructors with supplier, accumulatro and combiner
        // Does the same job as the above test case
        List<String> emails = MockData.getPeople().stream().map(Person::getEmail).collect(
                ArrayList::new, ArrayList::add,
                ArrayList::addAll);

        emails.forEach(System.out::println);
    }
}