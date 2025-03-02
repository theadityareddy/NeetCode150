// 01. 2Sum

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target
            int remainder = target - nums[i];

            // Check if the complement exists in the map (ensuring no repetition)
            // For example : key = 4; nums[0]=2 then 4-2 = 2
            // To avoid this we first check and then add
            if (map.containsKey(remainder)) {
                // Return indices if a valid pair is found
                return new int[] {map.get(remainder), i};
            }

            // Store the number and its index in the map
            map.put(nums[i], i);
        }

        // Return an empty array if no pair is found
        return new int[] {};
    }
}
