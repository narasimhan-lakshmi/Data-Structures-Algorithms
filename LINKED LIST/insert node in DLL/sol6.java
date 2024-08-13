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

class GfG {
    // Function to insert a new node at given position in doubly linked list.
    void addNode(Node head, int pos, int data) {
        if (head == null) return;

        Node current = head;
        int count = 0;

        
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        // Create the new node
        Node newNode = new Node(data);

        
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }
}