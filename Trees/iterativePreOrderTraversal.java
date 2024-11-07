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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
         st.push(root);
        if(root == null) return pre;

        while(!st.isEmpty()){
           root = st.pop();
            pre.add(root.val);

            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return pre;
    }
}

//1 => 2,3
// 2 => 4,5
// 5 => 6,7
// 3 => null,8
// 8 => 9
// preorder: 124567389