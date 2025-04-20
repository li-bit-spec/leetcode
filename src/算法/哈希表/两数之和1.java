package 算法.哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-05 14:57
 */
public class 两数之和1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] input = s.split("\\s+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int target = scanner.nextInt();
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
