// 217. Contains Duplicate (Easy)

import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>(); // Set to store unique numbers

        for (int num : nums) {
            if (seen.contains(num)) { // If number already exists, duplicate found
                return true;
            }
            seen.add(num); // Add number to set
        }

        return false; // No duplicates found
    }
}
