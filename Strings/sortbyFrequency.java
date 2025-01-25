class Solution {
    public String frequencySort(String s) {
         StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        // Count the frequency of each character
        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
        
        // Create a list of characters sorted by their frequency in descending order
        List<Character> ans = new ArrayList<>(mpp.keySet());
        ans.sort((ob1, ob2) -> mpp.get(ob2) - mpp.get(ob1));
        
        
        for (char c : ans) {
            for (int i = 0; i < mpp.get(c); i++) {
                sb.append(c);
            }
        }
        
        
        return sb.toString();
    }
}

/* 
Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 
*/