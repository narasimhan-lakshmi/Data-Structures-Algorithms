// LC 2145

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences) {
            curr += diff;
            minPrefix = Math.min(minPrefix, curr);
            maxPrefix = Math.max(maxPrefix, curr);
        }

        // Range of valid starting values:
        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int) Math.max(0, maxStart - minStart + 1);
    }
}


/* 
Example 1:

Input: differences = [1,-3,4], lower = 1, upper = 6
Output: 2
Explanation: The possible hidden sequences are:
- [3, 4, 1, 5]
- [4, 5, 2, 6]
Thus, we return 2.
Example 2:

Input: differences = [3,-4,5,1,-2], lower = -4, upper = 5
Output: 4
Explanation: The possible hidden sequences are:
- [-3, 0, -4, 1, 2, 0]
- [-2, 1, -3, 2, 3, 1]
- [-1, 2, -2, 3, 4, 2]
- [0, 3, -1, 4, 5, 3]
Thus, we return 4.
Example 3:

Input: differences = [4,-7,2], lower = 3, upper = 6
Output: 0
Explanation: There are no possible hidden sequences. Thus, we return 0.
*/