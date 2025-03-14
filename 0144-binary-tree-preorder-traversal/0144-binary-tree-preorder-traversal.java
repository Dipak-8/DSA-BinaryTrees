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
// <---------- RECURSIVE ---------->
 class Solution {
    public void preorderHelper(TreeNode root, List<Integer> answer) {
        if (root == null)   
            return;
            
        answer.add(root.val);
        preorderHelper(root.left, answer);
        preorderHelper(root.right, answer);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorderHelper(root, answer);
        return answer;
    }
}

// <---------- ITERATIVE ---------->
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();

//         if(root == null)
//             return answer;

//         stack.push(root);
//         while(!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             answer.add(node.val);

//             if(node.right != null)
//                 stack.push(node.right);
//             if(node.left != null)
//                 stack.push(node.left);
            
//         }
//         return answer;
//     }
// }
