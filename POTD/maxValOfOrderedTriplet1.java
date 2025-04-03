// LeetCode - 2873
 class Solution {
    public long maximumTripletValue(int[] nums) {
        
         long ans = 0;  
        long diff =0;
        long maxi = 0;  

        for (int num : nums) {
            ans = Math.max(ans, diff * num); 
            diff = Math.max(diff, maxi - num); 
            maxi = Math.max(maxi, num); 
        }

        return ans;

    }
}

/* 
Example 1:

Input: nums = [12,6,1,2,7]
Output: 77
Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
It can be shown that there are no ordered triplets of indices with a value greater than 77. 
Example 2:

Input: nums = [1,10,3,4,19]
Output: 133
Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
It can be shown that there are no ordered triplets of indices with a value greater than 133.
*/