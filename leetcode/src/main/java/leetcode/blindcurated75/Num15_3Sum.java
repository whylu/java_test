package leetcode.blindcurated75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Num15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0) {
                break; //Since the nums is sorted, if first number is bigger than 0, it is impossible to have a sum of 0
            }
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) { // skip same value

                int lo = i+1, hi = nums.length-1;
                int target = 0 - nums[i];

                while (lo<hi) {
                    if(target == nums[lo] + nums[hi]) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo<hi && nums[lo]==nums[lo+1]) {
                            lo++;
                        }
                        while (lo<hi && nums[hi]==nums[hi-1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else {
                        if(nums[lo] + nums[hi] < target) { // need increase value -> move lo right
                            lo++;
                        } else {  // need decrease value -> move hi left
                            hi--;
                        }
                    }

                }
            }

        }

        return result;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Set<String> exist = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer num = nums[i];
//            int target = 0 - num;
//
//
//            // two sum
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int j = 0; j < nums.length; j++) {
//                if(j==i) {
//                    continue;
//                }
//                int remain = target - nums[j];
//
//                Integer index = map.get(remain);
//                if(index!=null) { // found
//
//                    int[] found = new int[] {nums[i], nums[j], nums[index]};
//                    Arrays.sort(found);
//                    String key = found[0] + "," + found[1] + "," + found[2];
//                    if(!exist.contains(key)) {
//                        exist.add(key);
//                        ArrayList<Integer> values = new ArrayList<>();
//                        values.add(found[0]);
//                        values.add(found[1]);
//                        values.add(found[2]);
//                        result.add(values);
//                    }
//
//                }
//                map.put(nums[j], j);
//            }
//        }
//        return result;
//    }


}
