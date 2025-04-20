package 算法.数组.螺旋矩阵;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-05 21:10
 */
public class 螺旋矩阵II {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(generateMatrix(n));
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        // 遵循开闭右闭原则（第一个点）
        while (left <= right && top <= bottom) {
            // 左 -> 右
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            // 上 -> 下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            // 右 -> 左
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;
            // 下 -> 上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
