// LC 496

class Solution {
    public int[] nextGreaterElement(int[] a1, int[] a2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        for(int i = a2.length - 1; i >= 0; i--){
            int num = a2[i];
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            if(st.isEmpty()) {
                mpp.put(num, -1);
            } else {
                mpp.put(num, st.peek());
            }
            st.push(num);
        }
        
        for(int i = 0; i < a1.length; i++){
            a1[i] = mpp.getOrDefault(a1[i], -1);
        }
        
        return a1;
    }
}
/*
Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
*/
