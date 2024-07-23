

// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[low] <= arr[high]) {
            
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }
            
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                
                ans = arr[mid];
                index = mid;
                break;
            } else if (arr[mid] <= arr[high]) {
                
                high = mid - 1;
            } else if (arr[mid] >= arr[low]) {
                
                low = mid + 1;
            }
        }
        
        return index;
    }
}