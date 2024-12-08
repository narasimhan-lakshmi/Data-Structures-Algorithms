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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Final collection to store the result
        List<List<Integer>> collection = new ArrayList<>();

        // TreeMap to store nodes grouped by column and row
        TreeMap<Integer, Map<Integer, List<Integer>>> treeMap = new TreeMap<>();

        // Populate treeMap using inorder traversal
        inorderTraversal(root, treeMap, 0, 0);

        // Process treeMap to build the final result
        for (var colEntry : treeMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (var rowValues : colEntry.getValue().values()) {
                // Sort values at the same row before adding to the list
                Collections.sort(rowValues);
                list.addAll(rowValues); // Add sorted values to the list
            }
            collection.add(list); // Add the column list to the final result
        }

        return collection;
    }

    // Helper method to perform inorder traversal
    private static void inorderTraversal(TreeNode node, TreeMap<Integer, Map<Integer, List<Integer>>> treeMap, int column, int row) {
        if (node == null) {
            return; // Base case: stop recursion if node is null
        }

        // Add current node's value to treeMap at the corresponding column and row
        treeMap.computeIfAbsent(column, k -> new TreeMap<>())
               .computeIfAbsent(row, k -> new ArrayList<>())
               .add(node.val);

        // Traverse the left subtree with updated column and row
        inorderTraversal(node.left, treeMap, column - 1, row + 1);

        // Traverse the right subtree with updated column and row
        inorderTraversal(node.right, treeMap, column + 1, row + 1);
    }
}

//Sample input: [3,9,20,null,null,15,7]
// output : [[9],[3,15],[20],[7]]