package leetcode.blindcurated75;

import java.util.Arrays;

public class Num55_JumpGame {

    // time: O(n)
    // space: O(1)
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for (int i = nums.length-2; i >=0; i--) {
            if(i + nums[i] >= last) {
                last = i;
            }
        }
        return last==0;
    }

    // time: O(n*n)
    // space: O(n)
//    public boolean canJump(int[] nums) {
//        if(nums.length==0) {
//            return false;
//        }
//        boolean[] reachable = new boolean[nums.length];
//
//        reachable[nums.length-1] = true;
//        for (int i = nums.length-2; i >= 0; i--) {
//
//            int furthest = Math.min(i + nums[i], nums.length-1);
//            for (int jumpTo = i+1; jumpTo <= furthest; jumpTo++) {
//                if (reachable[jumpTo]) {
//                    reachable[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return reachable[0];
//    }

}
