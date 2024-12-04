import java.util.HashMap;
import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    // 默认构造函数
    TreeNode(){}
    // 单参数构造函数
    TreeNode(int val){this.val = val;}
    // 全参数构造函数
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 class Solution {
    /*
     // 1. 递归超时
     // 计算了root的四个孙子（左右孩子的孩子）为头结点的子树的情况，又计算了root的左右孩子为头结点的子树的情况，计算左右孩子的时候其实又把孙子计算了一遍。
     public int rob(TreeNode root){
         if(root == null){
             return 0;
         }
         // 当前节点偷钱
         int money = root.val;

         if(root.left != null){
             money += rob(root.left.left) + rob(root.left.right);
         }
         if(root.right != null){
             money += rob(root.right.left) + rob(root.right.right);
         }
         // 当前节点不偷钱 rob(root.left) + rob(root.right)
         return Math.max(money, rob(root.left) + rob(root.right));
     }*/
     /*
     // 2. 记忆化递推
    HashMap<TreeNode, Integer> map = new HashMap<>();
     public int rob(TreeNode root){

         if (root == null){
             return 0;
         }
         // 如果已经计算过，直接返回
         if(map.containsKey(root)){
             return map.get(root);
         }
         // 抢劫当前节点
         int money = root.val;
         if(root.left != null){
             money += rob(root.left.left) + rob(root.left.right);
         }
         if(root.right != null){
             money += rob(root.right.left) + rob(root.right.right);
         }
         int result = Math.max(money, rob(root.left) + rob(root.right));
         map.put(root, result);
         return result;
     }*/
     // 动态规划： 状态标记递归
     /*
     数组 [0] 表示 不偷， 数组 [1] 表示 偷
     3.1 当前节点偷: 左孩子不偷+ 右孩子不偷 + 当前节点偷
     root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     3.2 当前节点不偷: Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
     root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
      */
     public int rob(TreeNode root){
         int[] res = dfs(root);
         return Math.max(res[0],res[1]);
     }
     private int[] dfs(TreeNode root){
         if(root == null){
             return new int[]{0,0};
         }
         // 后序遍历
         int[] left = dfs(root.left);
         int[] right = dfs(root.right);

         // 偷当前节点
         int robThisNode = root.val + left[0] + right[0];

         // 不偷当前节点
         int skipThisNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

         return new int[]{skipThisNode, robThisNode};
     }

 }
public class _337 {
    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        // 调用解题方法
        Solution solution = new Solution();
        int maxAmount = solution.rob(root);
        // 打印结果
        System.out.println("最大抢劫金额为: " + maxAmount);
    }


}
