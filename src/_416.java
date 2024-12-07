import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _416 {
    // 问题可以转换为寻找是否存在总和为 sum/2 的子集
    public static boolean isSum(int[] array, int sum){
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        /*
        int[][] dp = new int[array.length][target+1];
        // 初始化第 0 行
        for(int j = array[0];j<=target;j++){
            dp[0][j] = array[0];
        }
        for(int i = 1;i< array.length;i++){
            for(int j=0;j<=target;j++){
                if(array[i]>j){
                    dp[i][j] = dp[i-1][j];
                    if(dp[i][j] == target){
                        return true;
                    }
                }else{
                    int putValue = array[i] + dp[i-1][j-array[i]];
                    int skipValue = dp[i-1][j];
                    dp[i][j] = Math.max(putValue, skipValue);
                    if(dp[i][j] == target){
                        return true;
                    }
                }
            }

        }*/
        int[] dp = new int[target+1];
        for(int j=array[0];j<=target;j++){
            dp[j] = array[0];
        }
        for(int i = 1;i< array.length ;i++){
            for(int j = target;j>=array[i];j--){
                dp[j] = Math.max(dp[j],dp[j-array[i]]+array[i]);
                if(dp[j]==target) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一行整数（空格分割）：");
        // 读取整行输入
        String input = scanner.nextLine();
        // 分割字符串并转换为整数数组
        // "\\s" 匹配任意空白字符,  "+" 表示匹配一个或多个连续的空白字符
        String[] parts = input.split("\\s+");
        int[] array = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        /*
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int[] array = list.stream().mapToInt(i -> i).toArray();
        */
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        Arrays.sort(array);
        // 背包的总容量
        // int target = sum/2;
        System.out.println(isSum(array, sum));
    }
}
