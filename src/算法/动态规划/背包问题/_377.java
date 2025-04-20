package 算法.动态规划.背包问题;

import java.util.Scanner;

/**
 * @author lhx
 * @project leetcode
 * @package PACKAGE_NAME
 * @date 2024/12/12 22:01
 * @description: 组合总和IV, 完全背包问题
 */
public class _377 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        int target = sc.nextInt();

        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        // 完全背包问题，顺序不同的序列被视作不同的组合

        // 1. 申请一维 dp 数组 （排列问题不可以用二维dp数组解决（比较麻烦）））
        int[] dp = new int[target+1];
        // 初始化
        dp[0] =1;
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]){
                    dp[j] = dp[j]+dp[j-nums[i]];
                }

            }
        }
        for(int j=0;j<=target;j++){
            System.out.print(dp[j]+" ");
        }
        System.out.println();
        return dp[target];
    }
}
