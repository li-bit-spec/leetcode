package 算法.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 李华宪
 * @Description
 * @create 2025-02-09 22:43
 */
public class 模拟递归调用栈 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(2)),
                new TreeNode(3, null, new TreeNode(6))
        );
        System.out.println(preorderTraversal(root));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
//            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
