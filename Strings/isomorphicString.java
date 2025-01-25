class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths differ, strings cannot be isomorphic
        if (s.length() != t.length()) return false;

        // HashMaps to track character mappings
        HashMap<Character, Character> mpp1 = new HashMap<>();
        HashMap<Character, Character> mpp2 = new HashMap<>();

        // Traverse both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i); // Character from string s
            char c2 = t.charAt(i); // Corresponding character from string t

            // Check if c1 is already mapped in mpp1
            if (mpp1.containsKey(c1)) {
                // If mapped value does not match c2, return false
                if (mpp1.get(c1) != c2) return false;
            } else {
                // Add new mapping from c1 to c2
                mpp1.put(c1, c2);
            }

            // Check if c2 is already mapped in mpp2
            if (mpp2.containsKey(c2)) {
                // If mapped value does not match c1, return false
                if (mpp2.get(c2) != c1) return false;
            } else {
                // Add new mapping from c2 to c1
                mpp2.put(c2, c1);
            }
        }

        return true;
    }
}

/*
Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true


 */