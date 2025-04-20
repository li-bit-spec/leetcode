package 算法.动态规划.子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-23 11:45
 */
public class 最长连续递增序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(findLengthOfLCIS(nums));
    }

    private static int findLengthOfLCIS(int[] nums) {
        /*
        注意这道题需要的是连续递增子序列
        dp[i] = dp[i-1] + 1 if nums[i] > nums[i-1]
         */
        int maxLIS = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }
}
