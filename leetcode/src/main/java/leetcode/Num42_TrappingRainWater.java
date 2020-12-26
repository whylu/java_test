package leetcode;

// https://leetcode.com/problems/trapping-rain-water/
public class Num42_TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while (left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax<rightMax) { // 只統計高度比較低的那一方積水
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
