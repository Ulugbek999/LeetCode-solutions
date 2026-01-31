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


    public boolean hasPathSum(TreeNode root, int targetSum) {

        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int result, int targetSum){

        if(root == null){
            return false;
        }

        result += root.val;

        if(root.left == null && root.right == null && result == targetSum){
            return true;
        }

        return dfs(root.left, result, targetSum) || dfs(root.right, result, targetSum);
    }

}