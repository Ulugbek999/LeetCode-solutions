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
    public void flatten(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();

        dfs(root, list);
        for(int i = 0; i<list.size()-1; i++){
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i + 1);
            cur.left = null;
            cur.right = next;
        }

        // for(TreeNode node : list){
        //     if(node != null)
        //     System.out.println(node.val);
        // }

    }

    private void dfs(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        list.add(node);
        dfs(node.left, list);
        dfs(node.right, list);

    }
}