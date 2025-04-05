// LC 992

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums, k - 1);
    } 
    public int helper(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int left = 0, right = 0, cnt = 0;
        
        for (right = 0; right < nums.length; right++) {
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if (mpp.get(nums[left]) == 0) {
                    mpp.remove(nums[left]);
                }
                left++;
            }

            cnt += right - left + 1;
        }
        
        return cnt;
    }
}
/*
Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
*/