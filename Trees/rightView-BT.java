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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightview(root, result, 0);
        return result;
    }

    public void rightview(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightview(curr.right, result, currDepth + 1);
        rightview(curr.left, result, currDepth + 1);
    }
}
//sample input: [1,2,3,null,5,null,4]
//output : [1,3,4]