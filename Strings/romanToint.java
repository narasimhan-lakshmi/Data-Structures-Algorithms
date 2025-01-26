class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);
        
        // Traverse the string
        for (int i = 0; i < s.length() - 1; i++) {
            // If the current value is less than the next value, subtract it
            if (mpp.get(s.charAt(i)) < mpp.get(s.charAt(i + 1))) {
                ans -= mpp.get(s.charAt(i));
            } else {
                // Otherwise, add it
                ans += mpp.get(s.charAt(i));
            }
        }
        
        // Add the value of the last character
        ans += mpp.get(s.charAt(s.length() - 1));
        
        return ans;
    }
}
/* 
Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/