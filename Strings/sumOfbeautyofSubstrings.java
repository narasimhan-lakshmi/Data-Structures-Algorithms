class Solution {
    public int getMinCount(int [] freq){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]!=0){ //no character will have zero freqency
            //all will atleast occur once
                min = Math.min(min,freq[i]);
            }
        }
        return min;
    }
    public int getMaxCount(int [] freq){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            max = Math.max(max,freq[i]);
        }
        return max;
    }
    
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int [] freq = new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int beauty = getMaxCount(freq)-getMinCount(freq);
                sum +=  beauty;
            }
        }
        return sum;
    }
}

/* 
Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 
*/