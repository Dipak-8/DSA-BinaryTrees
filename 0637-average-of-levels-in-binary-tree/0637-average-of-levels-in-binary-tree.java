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
     public List<List<Integer>> levelOrder(TreeNode root, List<Double> result) {
        List<List<Integer>> answer = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return answer;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); 
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll(); 
                
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                
                temp.add(node.val);
            }
            int size = temp.size();
            double sum = 0;
            for(int j : temp) {
                sum += j;
            } 
            double avg = sum/size;
            result.add(avg);
            answer.add(temp);
        }
        return answer;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        levelOrder(root, result);
        return result;
    }
}