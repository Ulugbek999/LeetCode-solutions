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
    public boolean evaluateTree(TreeNode root) {
        //2 == or
        //3 == and
        return dfs(root);
    
    }

    private boolean dfs(TreeNode node){

        if(node == null){
            return true;
        }


        if(node.val == 2){
            return dfs(node.left) || dfs(node.right);
        }else if(node.val == 3){
            return dfs(node.left) && dfs(node.right);
        }

        if(node.val == 1){
            return true;
        }

        if(node.val == 0){
            return false;
        }


        
        return false;


    }


}