
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int  maxcnt = 0;
        int ind  = -1;
        for(int i=0;i<n;i++){
            int cnt = m - lowerbound(arr[i],m,1);
            if(cnt > maxcnt){
                maxcnt = cnt;
                ind = i;
            }
            
        }
        return ind;
    }
    
    int lowerbound(int arr[],int n, int target){
        int low = 0 , high = n -  1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}