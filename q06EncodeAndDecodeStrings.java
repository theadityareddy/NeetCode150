// 271 Encode and Decode Strings (Med)

import java.util.*;

class Solution {

    // Encodes a list of strings into a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        
        // Iterate through each string in the list
        for(String str : strs){
            // Append the length of the string, followed by '#' delimiter, and then the string itself
            sb.append(str.length()).append("#").append(str);
        }
        
        // Return the encoded string
        return sb.toString();
    }

    // Decodes a single string back into a list of original strings.
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        // Iterate through the encoded string
        while(i < str.length()){
            int j = i;
            
            // Find the position of '#' which separates length from the actual string
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract the length of the next string
            int len = Integer.parseInt(str.substring(i, j));

            // Extract the actual string using the obtained length
            String extractedStr = str.substring(j + 1, j + 1 + len);
            ans.add(extractedStr);

            // Move i to the start of the next encoded string
            i = j + 1 + len;
        }

        // Return the decoded list of strings
        return ans;
    }
}
