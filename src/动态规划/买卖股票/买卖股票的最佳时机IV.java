package 动态规划.买卖股票;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-22 20:26
 */
public class 买卖股票的最佳时机IV {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 最多 k 笔交易
        int k = scanner.nextInt();
        String[] arr = input.split("\\s+");
        int[] prices = new int[arr.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(k, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        /*
         总结III的规律，我们可以假设 dp[n][2k+1]
         当 j 为奇数时，表示持有第 j 支股票: dp[i][j] = max(dp[i-1][j], dp[i-1][j-1] - prices[i])
         当 j 为偶数时，表示不持有第 j 支股票(0 除外): dp[i][j] = max(dp[i-1][j], dp[i-1][j-1] + prices[i])
         */
        int n = prices.length;
        if (k == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2 * k + 1];
        // 初始化
        for (int j = 0; j < 2 * k + 1; j++) {
            if (j % 2 == 1) {
                dp[0][j] = -prices[0];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[n - 1][2 * k];
    }
}
