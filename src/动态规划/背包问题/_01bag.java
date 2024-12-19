package 动态规划.背包问题;

import java.util.Scanner;

public class _01bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for(int i=0;i<n;i++){
            weight[i] = scanner.nextInt();
        }
        for(int j=0;j<n;j++){
            value[j] = scanner.nextInt();
        }
        /*
        // 二维 dp 数组
        int[][] dp = new int[n][bagweight+1];

        // 第 0 行进行初始化
        for(int j = weight[0];j<=bagweight;j++){
            dp[0][j] = value[0];
        }
        for(int i=1;i<n;i++){
            for(int j = 0;j<=bagweight;j++){

                if(weight[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 把第 i 个放入背包中
                    int putValue = value[i] + dp[i-1][j-weight[i]];
                    // 不放入
                    int skipValue = dp[i-1][j];
                    dp[i][j] = Math.max(putValue, skipValue);
                }

            }
        }
        System.out.println(dp[n-1][bagweight]);*/
        // 一维 dp 数组
        int[] dp = new int[bagweight+1];
        for(int i =0;i<n;i++){
            for (int j = bagweight;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[bagweight]);
        scanner.close();
    }
}
