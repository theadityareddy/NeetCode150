// 49. Group Anagrams (Med)

import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // If the input array is empty, return an empty list
        if (strs.length == 0) {
            return new ArrayList();
        }

        // HashMap to store anagram groups with a unique frequency key
        HashMap<String, List<String>> map = new HashMap<>();

        // Frequency array to track character occurrences
        int freq[] = new int[26];

        // Iterate over each string in the input array
        for (String s : strs) {
            Arrays.fill(freq, 0); // Reset frequency array for each string

            // Count frequency of each character in the string
            for (char c : s.toCharArray()) {
                freq[c - 'a']++; 
            }

            // Construct a unique key based on character frequencies
            StringBuilder sb = new StringBuilder();
            for (int i : freq) {
                // Without a separator, a frequency array like [1, 11] would be indistinguishable from [11, 1]
                sb.append("#"); // Separator to differentiate counts 
                sb.append(i);
            }

            String key = sb.toString(); // Generate the unique key for the anagram group

            // If key is not in the map, initialize a new list for the group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the string to the corresponding anagram group
            map.get(key).add(s);
        }

        // Convert the map values (anagram groups) into a list and return
        return new ArrayList<>(map.values());
    }
}
