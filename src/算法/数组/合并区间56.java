package 算法.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-06 21:18
 */
public class 合并区间56 {
    public static void main(String[] args) throws Exception {

    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int[] temp = intervals[0];
        for (int i = 1; i < n; i++) {
            if (temp[1] > intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                res.add(temp);
                temp = intervals[i];
            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
}
