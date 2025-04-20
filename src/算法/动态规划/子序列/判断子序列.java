package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-25 16:45
 */
public class 判断子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
    }

    private static boolean isSubsequence(String s, String t) {
        /*
        dp[i][j] 表示 s[0,i-1] 与 t[0,j-1] 公共子序列的长度
        if s[0,i-1] == t[0,j-1]
            dp[i][j] = dp[i-1][j-1] + 1
        else
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
         */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength == s.length();
    }

}
