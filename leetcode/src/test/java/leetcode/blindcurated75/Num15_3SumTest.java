package leetcode.blindcurated75;

import org.junit.Test;

import java.util.List;

public class Num15_3SumTest {

    @Test
    public void threeSum() {
        Num15_3Sum solve = new Num15_3Sum();
        List<List<Integer>> lists = solve.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
    @Test
    public void threeSum2() {
        Num15_3Sum solve = new Num15_3Sum();
        List<List<Integer>> lists = solve.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4});
        System.out.println(lists);
    }
}