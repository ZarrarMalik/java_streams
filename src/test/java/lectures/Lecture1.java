package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

import beans.Person;
import mockdata.MockData;

public class Lecture1 {

	@Test
	public void imperativeApproach() throws IOException {
		int limit = 10;
		int index = 0;
		List<Person> people = MockData.getPeople();
		List<Person> iteratrePeopleList = new ArrayList<>();
		for (Person person : people) {
			if (person.getAge() <= 18) {
				iteratrePeopleList.add(person);
				index++;
				if (index == limit) {
					break;
				}
				System.out.println(person);
			}
		}
		assertThat(iteratrePeopleList).isNotEmpty();
		// 1. Find people aged less or equal 18
		// 2. Then change implementation to find first 10 people
	}

	@Test
	public void declarativeApproachUsingStreams() throws Exception {
		ImmutableList<Person> people = MockData.getPeople();

		List<Person> ageLessThan18 = people.stream().filter(x1 -> x1.getAge() <= 18)
				.collect(Collectors.toList());
		ageLessThan18.forEach(System.out::println);
		assertThat(ageLessThan18).isNotEmpty().hasAtLeastOneElementOfType(Person.class);

		// With Limit
		List<Person> ageLessThan182 = people.stream().filter(x1 -> x1.getAge() <= 18).limit(10)
				.collect(Collectors.toList());
		ageLessThan182.forEach(System.out::println);
		assertThat(ageLessThan182).isNotEmpty().hasAtLeastOneElementOfType(Person.class);
	}
}
