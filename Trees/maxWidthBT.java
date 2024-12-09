/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // Return 0 for an empty tree

        int maxWidth = 0; // Initialize maximum width
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>(); // Queue to hold nodes and their indices
        queue.offer(new Pair<>(root, 0)); // Start with the root at index 0

        while (!queue.isEmpty()) {
            int size = queue.size(); // Get the number of nodes at the current level
            int start = queue.peek().getValue(); // Index of the first node in the level
            int end = start; // Initialize the last node's index as the first node's index

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll(); // Dequeue the current node
                TreeNode node = current.getKey(); // Extract the tree node
                int index = current.getValue(); // Extract the node's index

                if (i == size - 1) { // Update the last node's index at the level
                    end = index;
                }

                // Add the left child with its calculated index
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, index * 2));
                }

                // Add the right child with its calculated index
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, index * 2 + 1));
                }
            }

            // Update the maximum width using the indices of the first and last nodes
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth; // Return the maximum width found
    }
}
//sample input : root = [1,3,2,5,3,null,9]
//           1 
//         /   \
//        3     2
//       / \     \
//      5   3     9
 //output: The maximum width exists in the third level with length 4 (5,3,null,9).