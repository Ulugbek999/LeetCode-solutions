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

    public TreeNode sortedArrayToBST(int[] nums) {
        
        int rootVal = nums[nums.length/2];
        TreeNode root = new TreeNode(rootVal);
        

        dfs(root, Arrays.copyOfRange(nums, 0, nums.length/2));
        dfs(root, Arrays.copyOfRange(nums, nums.length/2+1, nums.length));

        return root;
    }

    private void dfs(TreeNode root, int[] nums){

        if(nums.length == 0){
            return;
        }

        int newRoot = nums[nums.length/2];

        TreeNode node = new TreeNode(newRoot);

        if(newRoot < root.val){
            root.left = node;
        }else{
            root.right = node;
        }

        dfs(node, Arrays.copyOfRange(nums, 0, nums.length/2));
        dfs(node, Arrays.copyOfRange(nums,nums.length/2+1,nums.length));

    }
    

    // private void realDfs(TreeNode root, Stack<Integer> children){

    //     if(children.isEmpty()){
    //         return;
    //     }

    //     int currVal = children.pop();

    //     if(currVal < root.val){
    //         root.left = new TreeNode(currVal);
    //         realDfs(root.left, children);
    //     }
        
    //     if(currVal > root.val){
    //         root.right = new TreeNode(currVal);
    //         realDfs(root.right, children);
    //     }       
    // }



    // private void dfs(TreeNode root, Stack<Integer> leftChildren, Stack<Integer> rightChildren){

    //     if(leftChildren.isEmpty() || rightChildren.isEmpty()){
    //         return;
    //     }


    //     int currLeft = leftChildren.pop();
    //     int currRight = rightChildren.pop();
        
        
    //     if(currLeft < root.val){
    //         root.left = new TreeNode(currLeft);
    //         dfs(root.left, leftChildren, rightChildren);
            
    //     }

    //     if(currLeft > root.val){
    //         root.right = new TreeNode(currLeft);
    //         dfs(root.right, leftChildren, rightChildren);
    //     }

    //     if(currRight > root.val){
    //         root.right = new TreeNode(currRight);
    //         dfs(root.right, leftChildren, rightChildren);
    //     }

    //     if(currRight < root.val){
    //         root.left = new TreeNode(currRight);
    //         dfs(root.left, leftChildren, rightChildren);
    //     }
        
    //     return;
    // }
}