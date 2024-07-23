class Solution {
    public int[] moveZeroes(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return arr;
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, j++, i);
            }
        }
        return arr;
    }

    void swap(int arr[], int st, int end) {
        int t = arr[st];
        arr[st] = arr[end];
        arr[end] = t;
    }
}
