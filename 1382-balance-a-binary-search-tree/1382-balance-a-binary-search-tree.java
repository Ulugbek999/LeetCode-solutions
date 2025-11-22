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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return buildBalanced(nums, 0, nums.size() - 1);
    }

    //Get sorted values:
    private void inorder(TreeNode root, List<Integer> nums){
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }


    //Build balanced BST from sorted list
    private TreeNode buildBalanced(List<Integer> nums, int l, int r){
        if(l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = buildBalanced(nums, l, mid - 1);
        node.right = buildBalanced(nums, mid + 1, r);

        return  node;
    }

}