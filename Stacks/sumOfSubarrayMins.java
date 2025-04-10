// LC 907

class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> ngel = new Stack<>(); // next_greater_element_left
        Stack<Integer> nger = new Stack<>(); // next_greater_element_right

        long[] left = new long[arr.length];
        long[] right = new long[arr.length];

        // Next Greater Element to the Left
        for (int i = 0; i < arr.length; ++i) {
            int l = -1;
            while (!ngel.isEmpty() && arr[ngel.peek()] >= arr[i]) {
                ngel.pop();
            }

            if (!ngel.isEmpty()) {
                l = ngel.peek();
            }

            left[i] = i - l - 1;
            ngel.push(i);
        }

        // Next Greater Element to the Right
        for (int i = arr.length - 1; i >= 0; --i) {
            int r = arr.length;
            while (!nger.isEmpty() && arr[nger.peek()] > arr[i]) {
                nger.pop();
            }

            if (!nger.isEmpty()) {
                r = nger.peek();
            }

            right[i] = r - i - 1;
            nger.push(i);
        }

        long ans = 0;

        // Calculate the final result
        for (int i = 0; i < arr.length; ++i) {
            ans += (left[i] * right[i] + 1 + left[i] + right[i]) * arr[i];
        }

        return (int)(ans % 1_000_000_007);
    }
}
/*
Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
*/