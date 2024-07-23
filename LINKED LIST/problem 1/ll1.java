/*
class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
*/
class Solution {
    static Node constructLL(int arr[]) {
        // code here
      if(arr.length==0) return null; // nul
      Node head = new Node (arr[0]); // store head
      Node temp = head;
      
      for(int i=1;i<arr.length;i++){
          temp.next = new Node(arr[i]);
          temp = temp.next;
      }
      return head;
    }
  
    
}