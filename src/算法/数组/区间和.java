package 算法.数组;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-16 22:35
 */
public class 区间和 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] preSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
            preSum[i] = sum;
        }
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0) {
                System.out.println(preSum[b]);
            } else {
                System.out.println(preSum[b] - preSum[a - 1]);
            }
        }
        scanner.close();
    }
}
