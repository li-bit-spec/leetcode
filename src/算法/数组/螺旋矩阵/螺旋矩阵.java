package 算法.数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-05 21:53
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            // 从上到下
            if (top <= bottom && left <= right) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 从右到左
            if (top <= bottom && left <= right) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }
            // 从下到上
            if (top <= bottom && left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
