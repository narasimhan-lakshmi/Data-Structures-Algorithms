// LC 76

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return "";

        int[] hash = new int[128];  // ASCII size for all possible characters

        // Build the frequency map for string t
        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]++;
        }

        int left = 0, right = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (right < m) {
            char r = s.charAt(right);

            // If it's a character we care about (in t), count it
            if (hash[r] > 0) count++;

            hash[r]--;  // Decrease its frequency from our map (can go negative)
            right++;

            // If we have a valid window (all chars from t are matched)
            while (count == n) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIdx = left;
                }

                char l = s.charAt(left);
                hash[l]++;

                if (hash[l] > 0) {
                    count--;  // We've removed a required character
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
/* 
Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/