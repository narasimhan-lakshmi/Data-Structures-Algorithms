class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length()==0){
            return 0;
        }
        
        if(s.length() == 1){
            return 1;
        }
        
        int left = 0;
        int right = 0;
        int ans = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(right < s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right-left + 1);
            right++;
        }
        
        return ans;
    }
}

/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */