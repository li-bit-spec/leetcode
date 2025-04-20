package 算法.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-08 21:04
 */
public class 杨辉三角 {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> generate(int numRows) {
        // dp[i,j] = dp[i-1,j-1] + dp[i-1, j]
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        // 每行的第一个数和最后一个数都是1
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int a = res.get(i - 1).get(j - 1);
                int b = res.get(i - 1).get(j);
                row.add(a + b);
            }
            res.add(row);
        }
        return res;
    }
}
