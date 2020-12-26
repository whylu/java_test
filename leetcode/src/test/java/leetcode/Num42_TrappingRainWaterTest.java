package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Num42_TrappingRainWaterTest {

    @Test
    public void trap() {
        Num42_TrappingRainWater solve = new Num42_TrappingRainWater();
        int result = solve.trap(new int[]{4, 2, 0, 3, 2, 5});
        assertThat(result).isEqualTo(9);
    }


    @Test
    public void trap2() {
        Num42_TrappingRainWater solve = new Num42_TrappingRainWater();
        int result = solve.trap(new int[]{4, 2, 0, 3, 2, 5, 6, 2, 4});
//        assertThat(result).isEqualTo(9);
        System.out.println(result);
    }
}