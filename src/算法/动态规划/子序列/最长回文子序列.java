package 算法.动态规划.子序列;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-29 18:53
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    private static int longestPalindromeSubseq(String s) {
        /*
        dp[i][j] 表示 s[i, j] 中最长回文子序列的长度
        if s[i] == s[j] :
            dp[i, j] = dp[i+1][j-1] + 2
        else :
            1. 只加入s[i], dp[i+1][j]
            2. 只加入s[j], dp[i][j-1]
            dp[i][j] = max(dp[i+1][j], dp[i][j-1])
         */
        int[][] dp = new int[s.length()][s.length()];
        // 初始化，左下角开始递推，当i = j时, dp[i][j] = 1
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        // 因为 j 始终大于等于 i，所以只需要计算右上部分就行
        for (int i = s.length() - 2; i >= 0; i--) {
            // 当 i = s.length() - 1 时，不满足条件直接跳过
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
