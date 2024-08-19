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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Find the middle of the list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list
        ListNode newHead = Reverse(slow.next);
        ListNode first = head;
        
        // Pointer to the reversed second half
        ListNode second = newHead;
        
        // Compare the first and second halves
        while (second != null) {
            if (first.val != second.val) {
                Reverse(newHead);  // Restore the list before returning
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        Reverse(newHead);  // Restore the list before returning
        return true;
    }
    
    // Helper method to reverse a list
    private ListNode Reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;  // prev is the new head of the reversed list
    }
    
    // Helper method to find the middle of the list
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    }
