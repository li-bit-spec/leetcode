package 动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lhx
 * @project leetcode
 * @package PACKAGE_NAME
 * @date 2024/12/8 10:56
 * @description: 零钱兑换II - 完全背包问题dp
 */
public class _518 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总金额：");
        int amount = scanner.nextInt();
        scanner.nextLine(); // 吸收换行符
        System.out.println("请输入整数数组：");
        String input = scanner.nextLine();
//        scanner.close();
        String[] parts = input.split("\\s+");
        int[] coins = new int[parts.length];
        for(int i= 0;i<parts.length; i++){
            coins[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(change(amount, coins));
    }
    public static int change(int amount, int[] coins){
        /*
        完全背包问题：
        dp[i][j] : 使用[0,i]种硬币，组成容量为 j 的面额共有多少种方法。
        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
         */
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
//        dp[0] = 1;
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){
                dp[j] = 1;
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
        /*
        Arrays.sort(coins);
        if(amount==0){
            return 1; // 金额为 0 的特殊情况
        }
        if(coins.length == 0){
            return 0;// 没有硬币时无法凑成任何金额
        }
        int[][] dp = new int[coins.length][amount+1];
        // 初始化第一列，当金额为0的时候
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 1;
        }
        // 初始化第一行，只用第一种硬币
        for(int j=coins[0];j<=amount;j++){
//            dp[0][j] = dp[0][j-coins[0]];
            if(j%coins[0]==0){
                dp[0][j] = 1;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j =0;j<=amount;j++){
                if(j<coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[coins.length-1][amount];

         */

    }
}
