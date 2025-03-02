// 242. Valid Anagram (Easy)

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if(s.length() != t.length()){
            return false;
        }

        // Frequency array for 26 lowercase letters
        int freq[] = new int[26]; 
        
        // Update frequency: increment for 's' and decrement for 't'
        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero (i.e., all characters matched)
        for (int i = 0; i < 26; i++){
            if (freq[i] != 0){
                return false;
            }
        }

        return true; // Strings are anagrams
    }
}
