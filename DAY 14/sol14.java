class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid=0;
        int high = nums.length - 1;

        while(mid<=high){
        if(nums[mid]==0){
            swap(nums,low,mid);
            low++;
            mid++;
        }

        else if(nums[mid]==1){
            mid++;
        }
        else {
            swap(nums,mid,high);
            high--;
        }

        
    }
    }  

    private void swap(int [] nums,int start,int end){
        
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    
}