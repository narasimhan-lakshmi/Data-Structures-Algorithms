// LC 402

class Solution {
    public String removeKdigits(String num, int k) {
      Stack<Character> st = new Stack<>();
      int charpop = 0;
      String ans = "";
      for(char ch:num.toCharArray()){
        while(!st.isEmpty() && st.peek() > ch && charpop < k ){
            st.pop();
            charpop++;
        }
        if(st.isEmpty() && ch=='0') continue;
        st.push(ch);
      }  
      while(!st.isEmpty() && charpop < k){
        st.pop();
        charpop++;
      }
      if(st.isEmpty()) return "0";
      int n = st.size();
      for(int i=0;i<n;i++){
        ans = st.pop() + ans;
      }
      return ans;
    }
}
/*
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/