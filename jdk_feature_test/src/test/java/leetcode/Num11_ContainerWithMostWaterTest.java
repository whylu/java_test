package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Num11_ContainerWithMostWaterTest {

    Num11_ContainerWithMostWater test = new Num11_ContainerWithMostWater();
    @Test
    public void maxArea() {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int maxArea = test.maxArea(height);
        System.out.println(maxArea);


        maxArea = test.maxArea(new int[] {4,3,2,1,4});
        System.out.println(maxArea);
    }
}