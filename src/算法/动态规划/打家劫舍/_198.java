package 算法.动态规划.打家劫舍;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 打家劫舍
 * @create 2024-12-19 17:12
 */
public class _198 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        System.out.println("Money:" + rob(nums));
    }

    public static int rob(int[] nums) {
        // 1。 确定dp[i]: 偷到第i间房子，所获得的最大金额
        // 2。 递推公式：dp[i] = max(dp[i-2]+nums[i],dp[i-1])
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
