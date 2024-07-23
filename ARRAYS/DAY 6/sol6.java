class Solution {
    public void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    void reverse(int[] arr, int st, int en) {
        while (st < en) {
            int t = arr[st];
            arr[st] = arr[en];
            arr[en] = t;
            st++;
            en--;
        }
    }
}
