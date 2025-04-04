// LC 1004
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int cnt = 0;
        int right = 0;
       // int sum = 0;
        while(right<nums.length){
           // sum += nums[right];
           if(nums[right]==0) {
            --k;
           }
           right++;
           while(k<0){
            if(nums[left]==0){
                ++k;
            }
            left++;
           }
           cnt = Math.max(cnt, right-left);
        }
        return cnt;
    }
}
/* 
Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/