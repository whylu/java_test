package leetcode.blindcurated75;

import org.junit.Test;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
public class Num1_TwoSumTest {

    @Test
    public void twoSum() {
        Num1_TwoSum solution = new Num1_TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }


    @Test
    public void twoSum2() {
        Num1_TwoSum solution = new Num1_TwoSum();
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));
    }

}