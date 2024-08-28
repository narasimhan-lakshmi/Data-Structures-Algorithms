/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        int carry = helper(head);
        if (carry == 1) {
            Node n = new Node(1);
            n.next = head;
            head = n;
        }
        return head;
    }

    public int helper(Node head) {
        if (head == null) return 1;
        int c = helper(head.next);
        int sum = c + head.data;
        head.data = sum % 10;
        return sum / 10;
    }
}