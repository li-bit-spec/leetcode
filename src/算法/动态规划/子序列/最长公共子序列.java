package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-25 15:28
 */
public class 最长公共子序列 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        /*
        与最长重复子数组思路一样, 但是不需要是连续的
        dp[i][j] 表示 text[0, i-1] 与 [0, j-1] 的最长共同子序列
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
            dp[i][j] = dp[i-1][j-1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
