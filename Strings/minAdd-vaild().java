class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0;
        int add = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                cnt++;
            }
            else if(cnt>0) {
                cnt --;
            }
            else{
                add++;
            }
        }
        add += cnt;
        return add;
    }
}

/* 
Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
*/