// LC 904

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int left = 0, right = 0, cnt = 0;
        int k = 2;

        while (right < n) {
            hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);

            while (hm.size() > k) {
                hm.put(fruits[left], hm.get(fruits[left]) - 1);
                if (hm.get(fruits[left]) == 0) {
                    hm.remove(fruits[left]);
                }
                left++;
            }

            cnt = Math.max(cnt, right - left + 1);
            right++;
        }

        return cnt;
    }
}
/* 
Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/