// LC 846



class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> mpp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : hand) {
            mpp.put(val, mpp.getOrDefault(val, 0) + 1);
        }

        // Add unique elements to min-heap
        pq.addAll(mpp.keySet());

        while (!pq.isEmpty()) {
            int first = pq.peek();

            for (int i = 0; i < groupSize; i++) {
                int curr = first + i;

                if (!mpp.containsKey(curr)) return false;

                mpp.put(curr, mpp.get(curr) - 1);

                if (mpp.get(curr) == 0) {
                    mpp.remove(curr);

                    // only remove from PQ if curr is at the top
                    if (curr == pq.peek()) {
                        pq.poll();
                    }
                }
            }
        }

        return true;
    }
}
/*
Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.
*/