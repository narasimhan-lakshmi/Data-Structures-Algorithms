// LC 
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
     Map<Integer,Integer> hm = new HashMap<>();
     int prefixsum = 0;
     int cnt = 0;
      hm.put(0,1);
     for(int num:nums){
       prefixsum += (num%2);
       cnt += hm.getOrDefault(prefixsum-k,0);
     hm.put(prefixsum, hm.getOrDefault(prefixsum, 0) + 1);

     }
     return cnt;
    }
    
}
/* 
Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
*/