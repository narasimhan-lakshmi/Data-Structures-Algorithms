//LeetCode - 2874

class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;  
        long diff = Long.MIN_VALUE; // Tracks max (nums[i] - nums[j])
        long maxi = 0;  // Tracks max nums[i] seen so far

        for (int num : nums) {
            ans = Math.max(ans, diff * num); // Calculate triplet value
            diff = Math.max(diff, maxi - num); // Update max (nums[i] - nums[j])
            maxi = Math.max(maxi, num); // Update max nums[i]
        }

        return ans;
    }
}

