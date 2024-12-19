package 动态规划.背包问题;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 零钱兑换（完全背包问题）
 * @create 2024-12-18 16:54
 */
public class _322 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split("\\s+");
        int[] coins = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            coins[i] = Integer.parseInt(arr[i]);
        }
        int amount = sc.nextInt();
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        /*
          动态规划
          完全背包问题
          dp[j]表示凑成i的最小硬币数,
          则 dp[j-coins[i]] 表示凑成 j-coins[i]的最小硬币数
          dp[j] = Math.min(dp[j], dp[j-coins[i]]+1)
         */
        int[] dp = new int[amount+1];
        // 初始化，表示凑成金额为 0 需要 0 个硬币
        dp[0] = 0;
        // 初始化，表示凑成金额为 1,2,...,amount 需要 Integer.MAX_VALUE 个硬币（表示无法凑成）
        for(int j=1;j<=amount;j++){
            dp[j] = Integer.MAX_VALUE;
        }
        /*
        为什么设置 dp[j-coins[i]] != Integer.MAX_VALUE
        因为如果 dp[j - coins[i]] 的值为 Integer.MAX_VALUE，说明金额 j - coins[i] 无法凑成，此时不能用 coins[i] 来更新 dp[j]，否则会导致结果错误。
         */
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j-coins[i] >= 0 && dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }else {
            return dp[amount];
        }
    }
}
