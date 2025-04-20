package 算法.动态规划.买卖股票;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-22 22:09
 */
public class 买卖股票的最佳时间含手续费 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int fee = scanner.nextInt();  // 手续费
        scanner.close();
        String[] arr = input.split("\\s+");
        int[] prices = new int[arr.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(prices, fee));
    }

    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        /*
        持有股票的状态：dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i]) // 不需要扣手续费，卖出才需要
        不持有股票的状态：dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] + fee)
         */
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[n - 1][1];
    }

}
