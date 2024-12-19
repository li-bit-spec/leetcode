package 动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 最后一块石头的重量II （01 bag）
 * @create 2024-12-18 16:23
 */
public class _1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split("\\s+");
        int[] stones = new int[parts.length];

        for(int i=0;i<parts.length - 1; i++){
            stones[i] = Integer.parseInt(parts[i]);

        }
        System.out.println(lastStoneWeightII(stones));

    }
    public static int lastStoneWeightII(int[] stones){
        /*
         target = sum/2
         在 target 范围内寻找，石头所能达到的最大值dp[target]
         最后结果为 背包外石头的最小值：(sum-dp[target]) - 背包内石头的最大值：(dp[target])
         */
        Arrays.sort(stones);
        int sum = 0;
        for(int stone : stones){
            sum+=stone;
        }
//        int target = sum/2; // 向下取整
        int target = sum >> 1;
        int[] dp =new int[target+1];

        for(int j = stones[0];j<=target;j++){
            dp[j] = stones[0];
        }

        for(int i=1;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[target] -dp[target];
    }
}
