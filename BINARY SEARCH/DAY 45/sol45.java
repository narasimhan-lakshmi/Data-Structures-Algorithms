class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Max(nums);
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(sum(nums,mid)<=threshold ){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int sum(int [] nums,int  threshold){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double)nums[i]/threshold);
        }
        return sum;
    }

    private int Max(int nums[]){
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}