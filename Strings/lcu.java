class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Return empty string if the input is null or empty
        if (strs == null || strs.length == 0) return ""; 

        // Sort the array to bring similar prefixes closer
        Arrays.sort(strs); 

        // Get the first and last strings after sorting
        String first = strs[0]; 
        String last = strs[strs.length - 1]; 

        // Initialize a counter to track common prefix length
        int c = 0; 

        // Compare characters of the first and last string
        while (c < first.length()) { 
            if (first.charAt(c) == last.charAt(c)) c++; // Increment counter for matching characters
            else break; // Stop when characters don't match
        }

        // Return the common prefix or empty string if none exists
        return c == 0 ? "" : first.substring(0, c); 
    }
}

/* 
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/