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
    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(Math.abs(right - left) > 1) return false;

        // System.out.println(left + " " + right);

        boolean result = isBalanced(root.left) && isBalanced(root.right);


        return result;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }


        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }



}