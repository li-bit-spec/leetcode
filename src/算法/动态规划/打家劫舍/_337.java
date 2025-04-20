package 算法.动态规划.打家劫舍;

/**
 * @author 李华宪
 * @Description 打家劫舍III
 * @create 2024-12-19 18:33
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

public class _337 {
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        /*
        如果父节点被偷了那么它的两个子节点则不会被偷
        dp[i] = max(偷父节点+偷孙子节点，偷子节点）
        dp[i] = max(dp[
         */
        return 0;
    }
}
