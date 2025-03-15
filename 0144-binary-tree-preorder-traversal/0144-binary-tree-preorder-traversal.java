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
//  class Solution {
//     public void preorderHelper(TreeNode root, List<Integer> answer) {
//         if (root == null)   
//             return;
            
//         answer.add(root.val);
//         preorderHelper(root.left, answer);
//         preorderHelper(root.right, answer);
//     }

//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();
//         preorderHelper(root, answer);
//         return answer;
//     }
// }

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


//<---------- PREORDER, INORDER, POSTORDER (In One pass) ---------->
class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        if(root == null)
            return answer;

        stack.push(new Pair(root, 1));
        while(!stack.isEmpty()) {
            Pair current = stack.pop();

            if(current.num ==  1) {
                answer.add(current.node.val); //push to preorder list
                current.num++;
                stack.push(new Pair(current.node, current.num));

                if(current.node.left != null)
                    stack.push(new Pair(current.node.left, 1));
            } 
            else if(current.num == 2) {
                //push to inorder list
                current.num++;
                stack.push(new Pair(current.node, current.num));

                if(current.node.right != null)
                    stack.push(new Pair(current.node.right, 1));
            } 
            else {
                //push to postorder list
                continue;
            }
        }
        return answer;
    }
}


