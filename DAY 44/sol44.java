class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        // Apply binary search:
        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] bloomDay, int day, int m, int k) {
        int n = bloomDay.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
                if (cnt == k) {
                    noOfB++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return noOfB >= m;
    }
}
