class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        root = sortedMerge(root, root.next);

        return root;
    }
    Node sortedMerge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.bottom = sortedMerge(a.bottom, b);
        } else {
            result = b;
            result.bottom = sortedMerge(a, b.bottom);
        }

        return result;
    }
}
