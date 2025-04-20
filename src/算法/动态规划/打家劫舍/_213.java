package 算法.动态规划.打家劫舍;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 打家劫舍II
 * @create 2024-12-19 18:18
 */
public class _213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        /*
        分两种情况：max(取首不取尾，取尾不取首)
         */
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    public static int robRange(int[] nums, int start, int end) {
        // 动态规划
        // dp[i] = max(nums[i] + dp[i-2], dp[i-1])
        int n = nums.length - 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
