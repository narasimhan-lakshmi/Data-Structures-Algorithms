// LC 1358



class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() == 3) {
                cnt += s.length() - right;
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }

        return cnt;
    }
}

/* 
Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

*/