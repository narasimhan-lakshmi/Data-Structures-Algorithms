//LeetCode - 2780
class Solution {

    public int minimumIndex(List<Integer> nums) {
        // Find the majority element
        int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

        for (int num : nums) {
            if (num == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num;
                count = 1;
            }
        }

        // Count frequency of majority element
        for (int num : nums) {
            if (num == x) {
                xCount++;
            }
        }

        // Check if valid split is possible
        count = 0;
        for (int index = 0; index < n; index++) {
            if (nums.get(index) == x) {
                count++;
            }
            int remainingCount = xCount - count;
            // Check if both left and right partitions satisfy the condition
            if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
                return index;
            }
        }

        return -1;
    }
}
/* 
Input: nums = [1,2,2,2]
Output: 2
Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2]. 
In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3. 
In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split. 
It can be shown that index 2 is the minimum index of a valid split.

Example 3:

Input: nums = [3,3,3,3,7,2,2]
Output: -1
Explanation: It can be shown that there is no valid split.
 
*/