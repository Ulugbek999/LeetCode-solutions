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
        
        List<Integer> result = new ArrayList<>();
        
        dfs(result, root);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode node){
        if(node == null){
            return; 
        }
        dfs(result, node.left);
        result.add(node.val);
        dfs(result, node.right);
            
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // private void dfs(List<Integer> result, TreeNode node){
        
    //     if(node == null){
    //         return;
    //     }
        
    //     dfs(result, node.left);
    //     dfs(result, node.right);
        
        
    // }
    
    
}