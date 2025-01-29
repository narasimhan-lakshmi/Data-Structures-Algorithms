
class Solution {
    public int chkpal(String s , int left , int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int left = 0, right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = chkpal(s, i, i);     // Odd-length palindrome
            int len2 = chkpal(s, i, i + 1); // Even-length palindrome
            int len = Math.max(len1, len2);

            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;  
            }
        }
        return s.substring(left, right + 1);
    }
}

/* 
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
*/