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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head; // No need to reverse if list is empty or k is 1
        }

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kthnode = findKthNode(temp, k);

            if (kthnode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kthnode.next;
            kthnode.next = null; // Temporarily terminate the list for reversal
            ListNode newHead = reverse(temp);

            if (temp == head) {
                head = kthnode;
            } else {
                prevLast.next = kthnode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp;
    }
}
