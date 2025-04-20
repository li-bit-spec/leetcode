package 算法.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-19 00:31
 */
public class 快乐数 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = calculateSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private static int calculateSum(int n) {
        System.out.println(n);
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
//            sum += n % 10 * n % 10;
            n = n / 10;
        }
        System.out.println(sum);
        return sum;
    }
}
