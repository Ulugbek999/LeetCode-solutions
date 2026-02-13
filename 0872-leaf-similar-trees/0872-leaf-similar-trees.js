/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    
    const list1 = [];

    const list2 = [];

    dfs(root1, list1);
    dfs(root2, list2);

    if(list1.length !== list2.length) return false;

    for(let i = 0; i<list1.length; i++){
        if(list1[i] !== list2[i]){
            return false;
        }
    }


    return true;

};

function dfs(root, list){
    if(root === null){
        return null;
    }

    if(root.left === null && root.right === null){
        //then its a leaf node;
        list.push(root.val);
    }

    dfs(root.left, list);
    dfs(root.right, list);

    return list;
}