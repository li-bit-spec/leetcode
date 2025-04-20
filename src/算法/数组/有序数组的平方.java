package 算法.数组;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-04 20:36
 */
public class 有序数组的平方 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split("\\s+");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(sortedSquares(nums));
    }

    private static int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sorted[i] = nums[left] * nums[left];
                left++;
            } else {
                sorted[i] = nums[right] * nums[right];
                right--;
            }
        }
        for (int num : sorted) {
            System.out.println(num);
        }
        return sorted;
    }
}
