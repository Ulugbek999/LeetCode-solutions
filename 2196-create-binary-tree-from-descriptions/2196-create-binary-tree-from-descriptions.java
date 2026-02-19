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
    
    //is left == 1 -> this is left childe
    //is left == 0 -> this is right child
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        //int rootVal = findRoot(descriptions);

        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] sub : descriptions){
            int parentVal = sub[0];
            int childVal = sub[1];
            int isLeft = sub[2];
            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodes.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodes.get(parentVal);
            TreeNode child = nodes.get(childVal);

            if(isLeft == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }

            children.add(childVal);
        }
        TreeNode result = null;

        for(int val : nodes.keySet()){
            if(!children.contains(val)){
                result = nodes.get(val);
            }
        }
        return result;
    }
}