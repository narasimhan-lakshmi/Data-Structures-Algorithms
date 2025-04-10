// LC 20

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '{' || it == '[') {
                st.push(it);
            } else {
                if (st.isEmpty()) return false;
                char ch = st.pop();
                if ((it == ')' && ch != '(') || 
                    (it == '}' && ch != '{') || 
                    (it == ']' && ch != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}

/*
Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true


*/