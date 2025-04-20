package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-27 11:05
 */
public class 两个字符串的删除操作 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        System.out.println(minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        /*
        核心是找到两个字符串最大的相同子串(不需要连续)
        dp[i][j] 表示 word1[0, i-1] 与 word2[0, j-1] 最大相同的非连续子串的长度
        如果 word1[0, i-1] == word2[0, j-1] ， dp[i][j] = dp[i-1][j] + 1
            word2[0, i-1] != word2[0, j-1] ， dp[i][j] = max(dp[i-1][j],dp[i[j-1]) （在两个字符不相等的情况下，我们应该取之前状态中能形成最大相同子串的长度）
         */
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        int maxLength = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
//                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];

    }
}
