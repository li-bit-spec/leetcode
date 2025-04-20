package 算法.数组;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-04 20:51
 */
public class 长度最小的子数组 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split("\\s+");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        int target = scanner.nextInt();
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int minLen = Integer.MAX_VALUE;
        // 窗口内的和
        int sum = 0;
        for (int quick = 0; quick < nums.length; quick++) {
//            if(sum<target){
//                sum += nums[quick];
//            }else{
//                // 缩小窗口直到 sum < target
//                while(sum>=target){
//                    minLen = Math.min(minLen, quick - slow + 1);
//                    sum -= nums[slow];
//                    slow++;
//                }
//            }
            sum += nums[quick]; // 累加当前元素

            // 缩小窗口直到 sum < target
            while (sum >= target) {
                minLen = Math.min(minLen, quick - slow + 1);
                sum -= nums[slow];
                slow++;
            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
