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
    public void rightSide(List<Integer> answer, TreeNode root, int level) {
        if(root == null)
            return;
        if(level == answer.size())
            answer.add(root.val);
        rightSide(answer, root.right, level + 1);
        rightSide(answer, root.left, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        int level = 0;
        rightSide(answer, root, level);
        return answer;
    }
}