package 算法.数组;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-04 20:04
 */
public class 移除元素 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split("\\s+");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        int val = scanner.nextInt();
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int quick = 0; quick < nums.length; quick++) {
            if (nums[quick] != val) {
                nums[slow++] = nums[quick];
            }
        }
        return slow;
    }
}
