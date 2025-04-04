// LC 424
class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurence = new int [26]; //to store occurences
        int left = 0;
        //int right=0;
        int ans =0 ;
        int max = 0;
        for(int right =0;right<s.length();right++){
            max = Math.max(max, ++occurence[s.charAt(right) - 'A']) ; 
            //check for valid substring
            //length - max > k 
            //substring not validd ... move left
            //decrement value found at left
            if(right-left +1 - max > k){
              
                occurence[s.charAt(left) - 'A']--;
                left++;


            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
/* 
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
*/