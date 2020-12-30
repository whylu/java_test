package leetcode.blindcurated75;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Num55_JumpGameTest {

    @Test
    public void canJump() {
        Num55_JumpGame solve = new Num55_JumpGame();
        assertThat(solve.canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
        assertThat(solve.canJump(new int[]{3,2,1,0,4})).isFalse();
        assertThat(solve.canJump(new int[]{0, 1})).isFalse();
        assertThat(solve.canJump(new int[]{0, 2, 3})).isFalse();
        assertThat(solve.canJump(new int[]{3,0,8,2,0,0,1})).isTrue();

    }
    @Test
    public void canJump1() {
        Num55_JumpGame solve = new Num55_JumpGame();
        assertThat(solve.canJump(new int[]{})).isFalse();
        assertThat(solve.canJump(new int[]{0})).isTrue();
        assertThat(solve.canJump(new int[]{1})).isTrue();
    }
    @Test
    public void canJump2() {
        Num55_JumpGame solve = new Num55_JumpGame();
        int[] data = new int[25003];
        for (int i = 0; i < 25000; i++) {
            data[i] = 25000 - i;
        }
        data[25000] = 1;
        data[25001] = 0;
        data[25002] = 0;
        assertThat(solve.canJump(data)).isFalse();
    }
}