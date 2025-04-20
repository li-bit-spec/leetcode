package 算法.动态规划.买卖股票;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-22 20:51
 */
public class 最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");
        int[] prices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        /*
        卖出股票后有一天的冷冻期，不能买入股票
        总共有三种状态：
        0. 持有股票 dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[1]) 因为前一天不能处于冷冻期
        1. 不持有股票(明天非冷冻期) dp[i][1] = max(dp[i-1][1], dp[i-1][2])
            1.1 前一天也不持有股票，且非冷冻期，今天不操作：dp[i-1][1]
            1.2 前一天卖出了股票，今天处于冷冻期，且今天冷冻期结束，需要转换为非冷冻期：dp[i-1][2]
        2. 不持有股票（明天冷冻期） dp[i][2] = dp[i-1][0] + prices[i]
            2.1. 今天卖出的股票，因此前一天必须持有股票
         */
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 初始化
        dp[0][0] = -prices[0];
        // 不持有股票，且没有冷冻期
        dp[0][1] = 0;
        // 不持有股票，但冷冻期无意义
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
