package twoSum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {


    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4};

        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
