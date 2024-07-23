class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low<=high){
            int mid = (low + high) / 2;
            if(arr[mid]>=x){
                ans = mid ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; 
    }
    
}
