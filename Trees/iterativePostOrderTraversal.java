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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<TreeNode>();
         Stack<TreeNode> st2 = new Stack<TreeNode>();
         List<Integer> post = new ArrayList<Integer>();
         st1.push(root);
         if(root==null) return post;
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);

            if(root.left != null){st1.push(root.left);}
            if(root.right != null) {st1.push(root.right);}

        }
        while(!st2.isEmpty()){
            post.add(st2.pop().val);
        }
        return post;
    }
}

//1 => 2,3
// 2 => 4,5
// 5 => 6,7
// 3 => null,8
// 8 => 9
// postorder: 467529831