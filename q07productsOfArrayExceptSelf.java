// 238. Products Of Array Except Self (Med) - Using O(n) time without using division operator
// using auxillary arrays

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prevMul[] = new int[nums.length]; // Prefix product array
        int postMul[] = new int[nums.length]; // Suffix product array

        prevMul[0] = 1; // First element has no prefix
        postMul[nums.length - 1] = 1; // Last element has no suffix

        // Compute prefix products
        for (int i = 1; i < nums.length; i++) 
            prevMul[i] = prevMul[i - 1] * nums[i - 1];

        // Compute suffix products
        for (int i = nums.length - 2; i >= 0; i--) 
            postMul[i] = postMul[i + 1] * nums[i + 1];

        int ans[] = new int[nums.length]; // Result array
        // Compute final result
        for (int i = 0; i < ans.length; i++) 
            ans[i] = prevMul[i] * postMul[i];

        return ans;
    }
}
