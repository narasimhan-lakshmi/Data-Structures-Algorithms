class Solution {
    public boolean isAnagram(String s, String t) {
        
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) return false; 

        // Initialize a frequency array for 26 lowercase letters
        int[] cnt = new int[26]; 
        
        // Increment the frequency for characters in string 's'
        for (int i = 0; i < s.length(); i++) { 
            cnt[s.charAt(i) - 'a']++; 
        }
        
        // Decrement the frequency for characters in string 't'
        for (int j = 0; j < t.length(); j++) { 
            cnt[t.charAt(j) - 'a']--; 
        }
        
        // Check if all frequencies are zero
        for (int freq : cnt) { 
            if (freq != 0) return false; 
        }
        
        // All checks passed, so the strings are anagrams
        return true; 
    }
}

/* 
Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
*/