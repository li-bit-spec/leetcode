package 算法.动态规划.子序列;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-27 11:46
 */
public class 编辑距离 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "extcution";
        System.out.println(minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        /*
        dp[i][j] 表示将 word1[0, i-1]个字符转换为 word2[0, j-1] 字符所需的最小操作数
        if word1[i - 1] == word2[j - 1]:
            dp[i][j] = dp[i-1][j-1]
        else : 需要在以下三种操作中选择最小的：
            1. 插入一个字符：dp[i][j-1] + 1 (将word2[j-1]插入word1[i-1]后面，那么相当于把问题转换为将word1[0,i-1]转换为word2[0,j-2],即 dp[i][j-1])
            2. 删除一个字符：dp[i-1][j] + 1 (删除word1[i-1]，那么相当于把问题转换为将word1[0,i-2]转换为word2[0,j-1],即 dp[i-1][j])
            3. 替换一个字符：dp[i-1][j-1] + 1 (将word1[i-1]替换为word2[j-1], 那么剩余的子问题是将word1[i-2]转化word2[j-2], 即dp[i-1][j-1])
         */
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        // 第一行，当j为0，即word2为空串，需要不断将word1删除，直至为空
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // 第一列，当i为0，即word1为空串，需要不断在word1插入字符，直至为word2的长度
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        // 开始填表
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
