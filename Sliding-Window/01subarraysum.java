// LC 930

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    public int helper(int[] nums, int goal) {
        if (goal < 0) return 0; 
        
        int left = 0, sum = 0, cnt = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            
            while (sum > goal) {
                sum -= nums[left++];
            }

            cnt += (right - left + 1);
        }

        return cnt;
    }
}
/*
Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 */