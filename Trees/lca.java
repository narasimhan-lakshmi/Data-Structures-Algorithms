/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the current node is null or matches either p or q, return it.
        // This means either we've reached the end of a path, or found one of the nodes.
        if (root == null || root == p || root == q) return root;

        // Recursively search for the LCA in the left subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Recursively search for the LCA in the right subtree.
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If one of the subtrees returns null, it means both nodes are located
        // in the other subtree. Return the non-null subtree.
        if (left == null) {
            return right; // LCA is in the right subtree.
        } else if (right == null) {
            return left; // LCA is in the left subtree.
        } else {
            // If both left and right are non-null, this node is the LCA.
            return root;
        }
    }
}

// sample input :   3
//               /    \
//              5      1
//             / \    /  \
//            6   2   0  8
//               / \
//              7   4
// p = 5 , q = 1
//output : The LCA of nodes 5 and 1 is 3.

