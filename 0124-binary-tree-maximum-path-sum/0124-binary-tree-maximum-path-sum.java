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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode node, int[] res){
        if(node == null){
            return 0;    
        }
        int left = Math.max(dfs(node.left, res), 0);
        int right = Math.max(dfs(node.right, res), 0);
        res[0] = Math.max(left + right + node.val, res[0]);

        return node.val + Math.max(left, right);
    }


}