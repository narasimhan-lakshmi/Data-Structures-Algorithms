class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)) cnt++;
        }
        return cnt;
    }
}

/* 
Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

*/