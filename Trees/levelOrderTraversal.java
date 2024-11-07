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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        
        if (root == null) return wrapList; 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Add root to the queue

        while (!q.isEmpty()) {
            int level = q.size(); // Number of nodes at the current level
            List<Integer> subList = new ArrayList<>(); // List to hold nodes of the current level

            for (int i = 0; i < level; i++) {
                TreeNode current = q.poll(); // Get and remove the node from the queue
                subList.add(current.val); // Add the node's value to the subList

                // Add children of the current node to the queue
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            wrapList.add(subList); // Add the current level's subList to the wrapList
        }

        return wrapList;
    }
}


// 3 => 9 , 20
// 20 => 15, 7
// lvl order: [3],[9,20],[15,7]