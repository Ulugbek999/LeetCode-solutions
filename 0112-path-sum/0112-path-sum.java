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

    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        dfs(root, 0,targetSum);

        return res;
    }

    private int dfs(TreeNode root, int result, int targetSum){


        if(root == null){
            return result;
        }


        result += root.val;

        if(root.left == null && root.right == null && result == targetSum){
            res = true;
        }

        dfs(root.left, result, targetSum);
        dfs(root.right, result, targetSum);
        //System.out.println(result);
        return result;
    }

}