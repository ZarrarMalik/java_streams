package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String PREFIX = "[";
        String SUFFIX = "]";
        StringJoiner joiner = new StringJoiner(",", PREFIX, SUFFIX);
        for (String name : names) {

            joiner.add(name);
        }
        System.out.println(joiner.toString());
        assertThat(joiner.toString()).isNotEmpty();
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String nameWithComma = names.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println(nameWithComma);

        String nameWithMap = names.stream().map(String::toUpperCase)
                .collect(Collectors.joining(".", "#", "£"));
        System.out.println(nameWithMap);
        
        assertThat(nameWithMap).contains("MARCOS");
    }
}