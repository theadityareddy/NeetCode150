// 238. Products Of Array Except Self (Med) - Using O(n) time without using division operator
// using auxillary arrays

import java.util.Arrays;

// Time Complexity O(n) - Space Complexity O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, 1); // Initialize result array with 1

        int pre = 1, post = 1;

        // Compute prefix product and store in result
        for (int i = 0; i < n; i++) {
            result[i] = pre;    // Store prefix product (product of all elements before nums[i])
            pre *= nums[i];     // Update prefix product
        }

        // Compute suffix product and multiply with result
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= post;  // Multiply with suffix product (product of all elements after nums[i])
            post *= nums[i];    // Update suffix product
        }

        return result;
    }
}  




// OR



// Time Complexity O(n) - Space Complexity O(n)

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int prevMul[] = new int[nums.length]; // Prefix product array
//         int postMul[] = new int[nums.length]; // Suffix product array

//         prevMul[0] = 1; // First element has no prefix
//         postMul[nums.length - 1] = 1; // Last element has no suffix

//         // Compute prefix products
//         for (int i = 1; i < nums.length; i++) 
//             prevMul[i] = prevMul[i - 1] * nums[i - 1];

//         // Compute suffix products
//         for (int i = nums.length - 2; i >= 0; i--) 
//             postMul[i] = postMul[i + 1] * nums[i + 1];

//         int ans[] = new int[nums.length]; // Result array
//         // Compute final result
//         for (int i = 0; i < ans.length; i++) 
//             ans[i] = prevMul[i] * postMul[i];

//         return ans;
//     }
// }

