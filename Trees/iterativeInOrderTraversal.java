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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode  node = root;

       while(true){
        if(node != null){
            st.push(node);
            node = node.left;
        }
        else{
            if(st.isEmpty()) {break;}
            node = st.pop();
            in.add(node.val);
            node = node.right;
        }
       }
       return in;
    }
}
//1 => 2,3
// 2 => 4,5
// 5 => 6,7
// 3 => null,8
// 8 => 9
// inorder: 426571398