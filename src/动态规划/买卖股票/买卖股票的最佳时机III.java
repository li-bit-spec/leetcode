package 动态规划.买卖股票;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-21 21:46
 */
public class 买卖股票的最佳时机III {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        int[] prices = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            prices[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        /*
        一天总共有五个状态
        0：没有操作
        1：持有第一支股票（注意：不是买入第一支股票，而是持有第一支股票，是一种可延续的状态）
        2：不持有第一支股票
        3：持有第二支股票
        4：不持有第二支股票
        dp[i][j]：i 表示第 i 天，j 为[0,4] 五个状态，dp[i][j] 表示第 i 天状态 j 所持有的最大现金。

        递推公式：
        1. 持有第一支股票：dp[i][1] = max(dp[i-1][1],  - prices[i])
        2. 不持有第一支股票：dp[i][2] = max(dp[i-1][2], dp[i-1][1] + prices[i])
        3. 持有第二支股票：dp[i][3] = max(dp[i-1][3], dp[i-1][2] - prices[i])
        4. 不持有第二支股票：dp[i][4] = max(dp[i-1][4], dp[i-1][3] + prices[i])

         */
        int[][] dp = new int[n][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 第一天肯定还没有买入，怎么能卖出去
        dp[0][2] = 0;
        // 第二次买入的话，就相当于 第一次已经买入并且原价卖出了
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        // 最后结果肯定是手里不持有股票利润最高
        return Math.max(dp[n - 1][2], dp[n - 1][4]);

    }
}
