package leetcode.blindcurated75;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/submissions/
public class Num1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];

            Integer index = map.get(remain);
            if(index!=null) {
                return new int[] {i, index};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
