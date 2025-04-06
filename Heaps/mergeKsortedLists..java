// LC 23

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        for(ListNode node : lists){
           if(node != null) pq.offer(node);
        }
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while(!pq.isEmpty()){
            ListNode mini = pq.poll();
            curr.next = mini;
            curr = curr.next;
            if(mini.next != null){
                pq.add(mini.next);
            }
        }
        return temp.next;
    }
}

/* 
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
*/