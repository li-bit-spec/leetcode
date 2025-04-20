package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-25 15:45
 */
public class 不相交的线 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        scanner.close();
        String[] parts1 = input1.split("\\s+");
        String[] parts2 = input2.split("\\s+");
        int[] nums1 = new int[parts1.length];
        int[] nums2 = new int[parts2.length];
        for (int i = 0; i < parts1.length; i++) {
            nums1[i] = Integer.parseInt(parts1[i]);

        }
        for (int i = 0; i < parts2.length; i++) {
            nums2[i] = Integer.parseInt(parts2[i]);
        }
        System.out.println(maxUncrossedLines(nums1, nums2));
    }

    private static int maxUncrossedLines(int[] nums1, int[] nums2) {
        /*
        这个和最长公共子序列类似，（非连续）
        dp[i][j] 表示 [0, i-1] 与 [0, j-1] 最长公共子序列（非连续）
        dp[i][j] = dp[i-1][j-1] + 1 if nums1[i-1] == nums2[j-1] else max(dp[i-1][j], dp[i][j-1])
         */
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int maxLength = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}
