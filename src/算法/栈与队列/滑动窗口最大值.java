package 算法.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-03 20:34
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) throws Exception {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        if (nums.length <= k) {

            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            result[0] = max;
            return result;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return result;
    }
}
