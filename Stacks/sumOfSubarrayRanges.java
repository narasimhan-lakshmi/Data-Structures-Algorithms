// LC 2105



class Solution {
    public long subArrayRanges(int[] A) {
        long a = sumSubarrayMaxs(A);
        long b = sumSubarrayMins(A);
        return a - b;
    }

    public long sumSubarrayMaxs(int[] A) {
        Stack<int[]> s = new Stack<>();
        long a = 0;
        int n = A.length;

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || s.peek()[1] < A[i])) {
                int[] p = s.pop();
                int m = p[1]; // value
                int j = p[0]; // index
                int k = s.isEmpty() ? -1 : s.peek()[0]; // previous index
                int left = j - k; // number of subarrays to the left
                int right = i - j; // number of subarrays to the right
                a += (long) m * left * right;
            }
            if (i < n) s.push(new int[]{i, A[i]}); // push index and value
        }
        return a;
    }

    public long sumSubarrayMins(int[] A) {
        Stack<int[]> s = new Stack<>();
        long res = 0;
        int n = A.length;

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || A[s.peek()[0]] > A[i])) {
                int[] p = s.pop();
                int m = p[1]; // value
                int j = p[0]; // index
                int k = s.isEmpty() ? -1 : s.peek()[0]; // previous index
                int left = j - k; // number of subarrays to the left
                int right = i - j; // number of subarrays to the right
                res += (long) m * left * right;
            }
            if (i < n) s.push(new int[]{i, A[i]}); // push index and value
        }

        return res;
    }
}
/*
Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

*/