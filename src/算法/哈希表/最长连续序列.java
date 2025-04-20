package 算法.哈希表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-05 15:51
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        // 注意：遍历的是 set 否则会超时
        for (int num : set) {
            // 加一层判断条件，判断该元素是不是可能序列的起点
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(++num)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
