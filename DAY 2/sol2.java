class Solution {
    int print2largest(int arr[], int n) {
        int lg = arr[0];
        int sl = -1;
        for(int i = 1; i < n; i++) {
            if (arr[i] > lg) {
                sl = lg;
                lg = arr[i];
            } else if (arr[i] < lg && arr[i] > sl) {
                sl = arr[i];
            }
        }
        return sl;
    }
}