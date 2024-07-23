class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Max(weights); 
        for (int weight : weights) {
            sum += weight; 
        }
        
        int low = max; 
        int high = sum; 
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShipInDays(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean canShipInDays(int[] weights, int capacity, int days) {
        int requiredDays = 1;
        int currentLoad = 0;
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = weight;
                if (requiredDays > days) {
                    return false;
                }
            } else {
                currentLoad += weight;
            }
        }
        
        return true;
    }
    
    private int Max(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
