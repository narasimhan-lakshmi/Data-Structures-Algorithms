// LC 1780

class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n %3 == 2){
                 return false;
            }
            n /= 3;
        }
        return true;
    }
}

/* 
Example 1:

Input: n = 12
Output: true
Explanation: 12 = 31 + 32
Example 2:

Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 34
Example 3:

Input: n = 21
Output: false
*/