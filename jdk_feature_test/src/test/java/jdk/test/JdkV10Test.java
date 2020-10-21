package jdk.test;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdkV10Test {

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void Collectors_toUnmodifiable() {
        Set<String> set = Stream.of("A", "B", "C").collect(Collectors.toUnmodifiableSet());
        set.add("D");
    }
}
