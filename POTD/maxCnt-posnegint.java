// LC 2529

class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0 ;
        int zero = 0;
        int pos = nums.length;
        for(int i:nums){
            if(i<0) neg++;
            if(i==0) zero++;
        }
        return Math.max(neg,pos-neg-zero);
    }
}

/* 
Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
Example 2:

Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
*/