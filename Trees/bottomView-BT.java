import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Resultant list to store the bottom view
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // TreeMap to store the last node value at each horizontal distance (HD)
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for level-order traversal, storing nodes along with their HD
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0)); // Start with the root node at HD 0

        // Perform level-order traversal
        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; // Horizontal distance
            Node temp = it.node; // Current node

            // Update the node value at the current HD (overwrite to get the bottommost node)
            map.put(hd, temp.data);

            // Add left child with HD - 1
            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }

            // Add right child with HD + 1
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        // Extract values from the TreeMap and add them to the result list
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}

// Helper class to store a node and its horizontal distance
class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

//sample input :  
//    1
//  /   \
//  3     2
//output: 3 1 2