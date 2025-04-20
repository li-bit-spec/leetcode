package 算法.动态规划.背包问题;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 完全平方数（完全背包问题）
 * @create 2024-12-18 18:23
 */
public class _279 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(numSquares(n));
    }
    public static int numSquares(int n) {
        /*
        完全背包问题
        与零钱兑换同理
        背包容量为12，
        物品重量为1,4,9 或者 1,2,3
        dp[j] 表示 装满i的背包所需的最小物品数量
        dp[j] = min(dp[j], dp[j-nums[i]] + 1)
         */
        int sqrt = (int)Math.sqrt(n);
        int[] nums = new int[sqrt];
        for(int i = 0;i<sqrt;i++){
            // 1,4,9
            nums[i] = (i+1)*(i+1);
        }
        int[] dp = new int[n+1];
        for(int j=1;j<=n;j++){
            dp[j] = Integer.MAX_VALUE;
        }
        for(int i=0;i<sqrt;i++){
            for(int j=1;j<=n;j++){
                if(j-nums[i] >= 0){
                    dp[j] = Math.min(dp[j], dp[j-nums[i]] + 1);
                }
            }
        }
        return dp[n];
    }
}
