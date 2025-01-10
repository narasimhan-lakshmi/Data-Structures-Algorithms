class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
      int freq [] = new int [26];
      for(String str: words2){
            int temp [] = new int[26];
            for(char c: str.toCharArray()){
                temp [c - 'a']++;
                freq[c - 'a'] = Math.max(freq[c-'a'],temp[c-'a']);
            }
      }
      List<String> ans = new ArrayList<>();

        for(int j=0 ; j< words1.length ; j++){
            int [] word_freq = new int [26];
            for(char c : words1[j].toCharArray())
            word_freq[c-'a']++;
            int i =0;
            for(i=0; i< 26 ; i++){
                if(freq[i]!=0){
                    if(word_freq[i]>= freq[i]) continue;
                    else break;
                }
            }
            if(i==26) ans.add(words1[j]);

        }

        return ans;
    }
}

/* 
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Explanation :
1 . Check "facebook":
Letter counts: {'f': 1, 'a': 1, 'c': 1, 'e': 1, 'b': 1, 'o': 2, 'k': 1}
'e' appears 1 time (meets the requirement of 'e': 1).
'o' appears 2 times (meets the requirement of 'o': 1).
Universal.

2. Check "apple":
Letter counts: {'a': 1, 'p': 2, 'l': 1, 'e': 1}
'o' is missing → Does not satisfy the requirements.
Not universal
*/