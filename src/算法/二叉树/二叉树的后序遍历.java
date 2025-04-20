package 算法.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-29 21:08
 */
public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(2)),
                new TreeNode(3, null, new TreeNode(6))
        );
        System.out.println(postorderTraversal(root));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);

        postorder(root.right, result);
        result.add(root.val);

    }
}
