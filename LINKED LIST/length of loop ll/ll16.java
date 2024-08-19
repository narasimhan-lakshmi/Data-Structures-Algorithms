class Solution {
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  
            fast = fast.next.next; 

            if (slow == fast) {
                return findLength(slow);
            }
        }

        return 0;
    }

    private int findLength(Node slow) {
        Node temp = slow;
        int length = 1;

        while (temp.next != slow) {
            length++;
            temp = temp.next;
        }

        return length;
    }
}