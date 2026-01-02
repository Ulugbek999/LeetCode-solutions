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
        
        List<Integer> result = new ArrayList<>();
        // dfs(result, root);
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(stack.isEmpty() == false){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
                        if(curr.left != null) stack.push(curr.left);

        }        
        
        
        return result;
        
        
    }
    
    // public void dfs(List<Integer> result, TreeNode node){
    //     if(node == null){
    //         return;
    //     }
        
    //     result.add(node.val);
    //     dfs(result, node.left);
    //     dfs(result, node.right);
        
        
    // }
    
    //  public void dfs(List<Integer> result, TreeNode node){
    //     if(node == null){
    //         return;
    //     }
        
    //     result.add(node.val);
    //     dfs(result, node.left);
    //     dfs(result, node.right);
    // }
}