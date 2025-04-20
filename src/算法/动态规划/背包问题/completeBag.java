package 算法.动态规划.背包问题;

import java.util.Scanner;

/**
 * @author lhx
 * @project leetcode
 * @package PACKAGE_NAME
 * @date 2024/12/7 13:50
 * @description: 卡码网第52题，完全背包问题
 */
public class completeBag {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();
         int v= scanner.nextInt();
         int[] weight = new int[n];
         int[] value = new int[n];
         for(int i =0;i<n;i++){
             weight[i] = scanner.nextInt();
             value[i] = scanner.nextInt();
         }
         scanner.close();
         /*
         int[][] dp = new int[n][v+1];
         // 初始化
         for(int j =weight[0];j<=v;j++){
             dp[0][j] = value[0]*(j/weight[0]);
         }
         for(int i=1;i<weight.length;i++){
             for(int j=0;j<=v;j++){
                 if(j<weight[i]){
                     dp[i][j] = dp[i-1][j];
                 }else {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                 }
             }
         }
         System.out.println(dp[n-1][v]);*/
         int[] dp = new int[v+1];
         for(int j =weight[0];j<=v;j++){
             dp[j] = value[0]*(j/weight[0]);
         }
         for(int i =1;i<n;i++){
             for(int j=weight[i];j<=v;j++){
                 dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
             }
         }
         System.out.println(dp[v]);
    }
}

