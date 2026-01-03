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
    public int kthSmallest(TreeNode root, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l));
        dfs(root, queue);
        int result =0 ;
        for(int i = 0; i<k; i++){
            result = queue.poll();
        }

        return result;
    }

    public void dfs(TreeNode root, Queue<Integer> queue){
        if(root == null){
            return;
        }

        queue.add(root.val);
        dfs(root.left, queue);
        dfs(root.right, queue);
        return;
    }
}