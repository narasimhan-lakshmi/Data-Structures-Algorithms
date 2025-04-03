class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            
            if (bracket == '(') {
                if (cnt > 0) sb.append(bracket);
                cnt++;
            } else {
                cnt--;
                if (cnt > 0) sb.append(bracket);
            }
        }
        
        return sb.toString();
    }
}
/* 
Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

 */