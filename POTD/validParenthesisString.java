class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false; // Odd length cannot be valid

        int open = 0, flexible = 0;
        // Left-to-right pass
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            if (open < -flexible) return false; // Too many ')' to balance
        }

        int close = 0;
        flexible = 0;
        // Right-to-left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == ')') {
                close++;
            } else {
                close--;
            }
            if (close < -flexible) return false; // Too many '(' to balance
        }

        return true;
    }
}


/* 
Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

*/