/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = ancestor(root.left, p, q);
        TreeNode right = ancestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        return (left != null) ? left : right;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ancestor(root, p, q);
    }
}