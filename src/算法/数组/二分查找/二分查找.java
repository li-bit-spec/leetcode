package 算法.数组.二分查找;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-03 21:42
 */
public class 二分查找 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] input = line.split("\\s+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int target = scanner.nextInt();
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        /*
        二分查找：左闭右闭
         */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
