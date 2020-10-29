package leetcode;

// https://leetcode.com/problems/container-with-most-water/
public class Num11_ContainerWithMostWater {

    // time: O(N)
    // space: O(1)
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length-1;
        while (left<right) {
            int area = Math.min(height[right], height[left]) * (right-left);
            if(maxArea<area) {
                maxArea = area;
            }
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    // time: O(N^2)
    // space: O(1)
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i=0; i<height.length; i++) {
//            int area = area(0, i, height);
//            if(maxArea<area) {
//                maxArea = area;
//            }
//        }
//        return maxArea;
//    }
//
//    public int area(int start, int end, int[] height) {
//        int maxArea = 0;
//        for (int i=start; i<=end; i++) {
//            int area = Math.min(height[i], height[end]) * (end-i);
//            if(maxArea<area) {
//                maxArea = area;
//            }
//        }
//        return maxArea;
//    }
}
