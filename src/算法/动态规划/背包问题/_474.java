package 算法.动态规划.背包问题;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 一和零 ：01背包问题
 * @create 2024-12-19 15:50
 */
public class _474 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strs = input.split("\\s+");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(findMaxForm(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        /*
        转换为 01 背包问题
        相对于普通的 01 背包问题，它有两个重量的限制，分别为m和n
        而对应的价值则为子集个数最多，所以默认每个子集的价值为1
        需要三维数组 dp[i][j][k] 其中 i 代表第几个子集，j 代表背包重量中 0 的维度，k 代表背包重量中 1 的维度
        放入第i个之后的价值 = max(不放入第i个 , 放入第i个（需要加一）)
        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-strs[i-1].zeroLength][k-strs[i-1].oneLength] + 1)
         */
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        // 初始，当 j，k都为0时，只有一个空子集，价值为0
        // 当 i 为 0 时，当 j,k都大于第一个子集中 01个数的时候，初始化dp[0][j][k] = 1

        int[] zeroNums = new int[strs.length];
        int[] oneNums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            zeroNums[i] = zeroNum;
            oneNums[i] = oneNum;
        }

        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                if (j >= zeroNums[0] && k >= oneNums[0]) {
                    dp[0][j][k] = 1;
                }
            }
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zeroNums[i] && k >= oneNums[i]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroNums[i]][k - oneNums[i]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }
}
