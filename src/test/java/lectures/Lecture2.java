package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

	@Test
	public void range() throws Exception {
		// Simple for loop printing 1 to 10
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		// Prints 0 to 9
		IntStream.range(0, 10).forEach(System.out::println);
		// Prints 0 t0 10
		IntStream.rangeClosed(0, 10).forEach(System.out::println);
	}

	@Test
	public void rangeIteratingLists() throws Exception {
		List<Person> people = MockData.getPeople();
		/*
		 * Here we will use range rather than rangeclosed otherwise it throws
		 * arrayoutofbound Exception we use IntStream to get the indexes of elements of
		 * the list index just return the solutino of {}
		 */

		IntStream.range(0, people.size()).forEach(index -> {
			Person person = people.get(index);
			System.out.println(person);
		});

	}

	@Test
	public void intStreamIterate() throws Exception {
		/*
		 * returns the numbers from 0 to the limit operand + 1 adds the initial value
		 * mod gets the even number
		 */

		IntStream.iterate(0, operand -> operand + 1).filter(number -> number % 2 == 0).limit(20)
				.forEach(System.out::println);
	}

	@Test

	// Return a name from the list
	public void testFetchNameFromList() throws Exception {
		List<Person> people = MockData.getPeople();

		people.forEach(name -> {
			if (name.getFirstName().equals("Denney")) {
				System.out.println(name);
			};
		});
	}
}