package jdk.test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * check https://4comprehension.com/busy-developers-guide-to-java-9-10-11-12-13-and-above/
 */
public class JdkV13Test {

    enum MyEnum {
        ONE, TWO, THREE
    }

    @Test
    public void switch_test() {
        MyEnum num = MyEnum.ONE;
        String s = switch (num) {
            case ONE -> "1111";
            case TWO -> "222";
            default -> "xxxxx";
        };
        assertThat(s).isEqualTo("1111");


        String s2 = switch (num) {
            case ONE:
                yield "1111";
            case TWO:
                yield "222";
            default:
                yield "xxxxx";
        };
        assertThat(s2).isEqualTo("1111");
    }

    // https://openjdk.java.net/jeps/378
    @Test
    public void string_block() {
        String block1 = """
                        line1\nline2
                        lin3
                        line4""";
        assertThat(block1.lines().count()).isEqualTo(4);
        System.out.println(block1);

        System.out.println("---block2 ");
        String block2 = """
               line1\nline2
                   lin3
                       line4""";
        System.out.println(block2);
    }
}
