// 347. Top K Frequent Elements (Med)

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap to store the frequency of each number in the array
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // TreeMap to store numbers grouped by their frequency in descending order
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(Collections.reverseOrder());

        // Populate the TreeMap with frequency as the key and list of numbers as the value
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            // If frequency is not already in the TreeMap, add an empty list
            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), new ArrayList<>());
            }
            // Add the number to the corresponding frequency group
            map.get(entry.getValue()).add(entry.getKey());
        }

        // Array to store the result
        int[] result = new int[k];
        int i = 0;

        // Iterate over the values in descending order of frequency
        for (List<Integer> values : map.values()) {
            for (int num : values) {
                if (i < k) {
                    result[i++] = num; // Add the number to the result array
                } else {
                    break; // Stop if we have collected k elements
                }
            }
            if (i == k) {
                break; // Stop once we have k elements in the result
            }
        }

        return result; // Return the k most frequent elements
    }
}
