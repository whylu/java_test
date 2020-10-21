package jdk.test;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class JdkV11Test {

    @Test
    public void optional_isEmpty() {
        Optional<String> a = Optional.of("A");
        assertThat(a.isEmpty()).isFalse();
    }


    @Test
    public void testString() {
        assertThat("  ".isBlank()).isTrue();

        assertThat("aaaaa\nbbbb\n".lines().count()).isEqualTo(2);
        assertThat("aaaaa\nbbbb\nccc".lines().count()).isEqualTo(3);

        assertThat("AB".repeat(3)).isEqualTo("ABABAB");

        //strip() is "Unicode-aware" evolution of trim().
        assertThat("  AB   ".strip()).isEqualTo("AB");
        assertThat("  AB   ".strip()).isEqualTo("AB");

        String sss = "\u2000 AB \u2000";
        System.out.println(sss);
        assertThat(sss.trim()).isEqualTo(sss);
        assertThat(sss.strip()).isEqualTo("AB");
    }
}
