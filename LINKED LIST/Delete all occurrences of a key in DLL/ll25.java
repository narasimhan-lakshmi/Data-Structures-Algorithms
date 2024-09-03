/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here.
      Node temp = head;

        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    Node nxt = temp.next;
                    Node prevNode = temp.prev;

                    if (nxt != null) {
                        nxt.prev = prevNode;
                    }
                    if (prevNode != null) {
                        prevNode.next = nxt;
                    }
                }
            }
            temp = temp.next;
        }

        return head;
    }
}