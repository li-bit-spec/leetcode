package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-26 15:35
 */
public class 不同的子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
        System.out.println(numDistinct(s, t));
    }

    private static int numDistinct(String s, String t) {
        /*
        dp[i][j] 表示 s[0, i-1] 中有多少种 t[0, j-1]
        if s[i-1] == t[j-1] ：
                   用s[i-1] 来匹配的话，就不需要考虑 s[i-1]和t[j-1]了： dp[i-1][j-1]
                   不用s[i-1] 来匹配的话，不需要考虑s[i-1] 但是需要考虑t[j-1]：dp[i-1][j]
        else s[i-1]!=t[j-1] ，只能不用s[i-1]来匹配 ,不需要考虑s[i-1],需要考虑t[j-1] ：dp[i-1][j]
        所以递推公式：if s[i-1]==t[j-1] : dp[i][j] = dp[i-1][j-1] + dp[i-1][j] else: dp[i][j] = dp[i-1][j]
        初始化：递推公式是从左上推导出来，所以dp[i][0] 和 dp[0][j] 需要初始化
            dp[i][0] 表示 s[0, i-1] 有多少种 "" : 一种
            dp[0][j] 表示 s[0, 0] 有多少种 t[0, j] 当j=0 为 1, 其余 为0
         */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
