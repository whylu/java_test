package jdk.test;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
/**
 * check https://4comprehension.com/busy-developers-guide-to-java-9-10-11-12-13-and-above/
 */
public class JdkV9Test {

    @Test
    public void collections_of() {
        Set<String> set = Set.of("A", "B", "CCC", "ddd", "EEE");

        assertThat(set).contains("A");
        assertThat(set).hasSize(5);
    }
}
