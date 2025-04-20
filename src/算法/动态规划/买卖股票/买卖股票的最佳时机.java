package 算法.动态规划.买卖股票;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-20 15:48
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");
        int[] prices = new int[arr.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        /*
        dp[i][0] 第i天持有股票的最高利润
        dp[i][1] 第i天不持有股票的最高利润
        递推公式：
            dp[i][0]: 由两个状态推算而来：（1）第 i-1 天就持有股票，那么第 i 天持有股票的最高利润等于 第 i-1 天持有股票的最高利润
                                      （2）第 i 天才买入的这支股票，那么第 i 天持有股票的最高利润等于 -prices[i]
                       所以 dp[i][0] = Math.max(dp[i-1][0], - prices[i]);

            dp[i][1]: 由两个状态推算而来：（1）第 i-1 天就不持有股票，那么第 i 天不持有股票的最高利润等于 第 i-1 天不持有股票的最高利润
                                      （2）第 i 天才卖出这支股票，那么第 i 天卖出股票的最高利润等于 dp[i-1][0] + prices[i]
                       所以 dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
         */
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            // dp[i][0] 第i天持有股票的最高利润
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
