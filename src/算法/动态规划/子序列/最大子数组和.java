package 算法.动态规划.子序列;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2024-12-25 16:05
 */
public class 最大子数组和 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(maxSubArraySum(nums));
    }

    private static int maxSubArraySum(int[] nums) {
        /*
        dp[i] 表示[0, i]的最大的连续子数组的和
        if dp[i-1] > 0 dp[i] = dp[i-1]+ nums[i] else dp[i] = nums[i]
        dp[i] = max(dp[i-1] + nums[i], nums[i])
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
