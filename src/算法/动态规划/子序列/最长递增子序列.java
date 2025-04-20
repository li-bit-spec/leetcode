package 算法.动态规划.子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-23 11:02
 */
public class 最长递增子序列 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        /*
        注意不是连续子序列
        1. 状态定义：dp[i]表示 i 之前包括 i 的以 nums[i] 结尾的最长递增子序列的长度
                   dp[j]表示 [0, i-1] 之前的最长递增子序列的长度
        2. 状态转移方程：dp[i] = max(dp[i], dp[j] + 1)
         */
        int maxLIS = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }
}
