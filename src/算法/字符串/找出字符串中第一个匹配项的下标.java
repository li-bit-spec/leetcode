package 算法.字符串;

/**
 * @author 李华宪
 * @Description KMP算法
 * @create 2025-02-19 11:04
 */
public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {

    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return 0;
    }

    /**
     * 获取needle的前缀表
     *
     * @param needle
     * @return
     */
    private static int[] getPrefix(String needle) {
        int nee = needle.length();
        int[] next = new int[nee];
        int j = 0;
        next[0] = j;
        for (int i = 0; i < nee; i++) {

            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
