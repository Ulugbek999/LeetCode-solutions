/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {

        if(root == null ) return 0;
        return dfs(root);

        
    }

    private int dfs(Node node){
        if(node.children == null || node.children.size() == 0){
            return 1;
        }

        int max = 0;
        for(Node child : node.children){
            max = Math.max(max, dfs(child));
        }

        return max + 1;
    }


}