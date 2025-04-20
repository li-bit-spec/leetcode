package 算法.数组;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-16 22:50
 */
public class 开发商购买土地 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] land = new int[n][m];
        int[] row = new int[n];
        int[] col = new int[m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                land[i][j] = scanner.nextInt();
                row[i] += land[i][j];
                col[j] += land[i][j];
                sum += land[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        // 统计行划分的最小差值
        int preRow = 0;
        for (int i = 0; i < n; i++) {
            preRow += row[i];
            min = Math.min(min, Math.abs(preRow - (sum - preRow)));
        }
        // 统计列划分的最小差值
        int preCol = 0;
        for (int j = 0; j < m; j++) {
            preCol += col[j];
            min = Math.min(min, Math.abs(preCol - (sum - preCol)));
        }
        System.out.println(min);
    }
}
