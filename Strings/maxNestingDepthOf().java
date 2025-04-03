class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int cnt = 0; 
        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            if (b == '(') {
                cnt++;
                depth = Math.max(depth, cnt); 
            } else if (b == ')') {
                cnt--;
            }
        }
        return depth;
    }
}
 /* 
 xample 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"


 */