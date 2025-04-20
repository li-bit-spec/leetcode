package 算法.动态规划.背包问题;

import java.util.Scanner;

/**
 *@Description 爬楼梯（卡码网进阶版）完全背包问题
  *@author          李华宪
  *@create          2024-12-18 16:23
  */  
public class _57ka {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       // 共有 n 层阶梯
       int n = scanner.nextInt();
       // 每次至多爬 m 层，至少 1 层
       int m = scanner.nextInt();
       scanner.close();
       /*
       可以看作完全背包的排列问题
       背包容量为 n
       物品重量为 1,2,...,m
        */
       int[] dp = new int[n+1];
       dp[0] = 1;
       for(int j=1; j<=n; j++){
           for(int i=1; i<=m; i++){
               if(j-i >= 0){
                   dp[j] += dp[j-i];
               }
           }
       }
       System.out.println(dp[n]);
    }
}
