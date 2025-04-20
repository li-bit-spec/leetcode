package 算法.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-29 21:08
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 二叉树的前序遍历 {
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
        // 终止条件
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
