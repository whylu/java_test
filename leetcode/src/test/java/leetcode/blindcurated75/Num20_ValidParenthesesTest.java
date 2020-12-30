package leetcode.blindcurated75;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Num20_ValidParenthesesTest {
    Num20_ValidParentheses t = new Num20_ValidParentheses();

    @Test
    public void isValid() {
        assertThat(t.isValid("{}")).isTrue();
        assertThat(t.isValid("()[]{}")).isTrue();
        assertThat(t.isValid("(]")).isFalse();
        assertThat(t.isValid("{[]}")).isTrue();
        assertThat(t.isValid("([)]")).isFalse();
        assertThat(t.isValid("(){}}{")).isFalse();
        assertThat(t.isValid("(}{)")).isFalse();

        assertThat(t.isValid("{[{()()()}]}")).isTrue();
        assertThat(t.isValid("{")).isFalse();
        assertThat(t.isValid("]")).isFalse();
    }
}