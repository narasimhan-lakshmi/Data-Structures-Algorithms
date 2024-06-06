class Solution{
    static int searchInSorted(int arr[], int N, int K){
   int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            
            if (arr[mid] == K) {
                return 1;
            }

           
            if (arr[mid] < K) {
                left = mid + 1;
            }
            
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}