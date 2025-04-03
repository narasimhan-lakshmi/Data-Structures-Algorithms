class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s = countAndSay(n-1);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            cnt++;
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)){
                sb.append(cnt).append(s.charAt(i));
                cnt = 0;
            }
        }
        return sb.toString();
    }
   
}

/* 
Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

Explanation:

This is the base case.
*/