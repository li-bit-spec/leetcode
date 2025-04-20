package 算法.动态规划.子序列;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-29 18:29
 */
public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    private static int countSubstrings(String s) {
        /*
        dp[i][j] 表示 子字符串[i, j] 是否回文
        如果 s[i]==s[j] :
            1. 当 i==j : 同一个字符，肯定是回文，dp[i][j] = true;
            2. 当 i+1 = j: 例如：aa，也是回文：dp[i][j] = true
            3. j > i+1 : dp[i][j] = dp[i+1][j-1]
        如果 s[i]!=s[j]:
            dp[i][j] = false;
         */
        // 初始化
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        // 遍历顺序：是从左下角开始递推
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;

                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    // 统计回文子串的数量
                    count++;

                }
            }
        }
        return count;
    }
}
