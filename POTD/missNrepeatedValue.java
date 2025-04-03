//LC 2965

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
          int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        int repeated = -1, missing = -1;

        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }

        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) repeated = num;
            if (freq[num] == 0) missing = num;
        }

        return new int[]{repeated, missing};
    }
}

/* 
Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
*/