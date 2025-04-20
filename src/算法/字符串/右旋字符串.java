package 算法.字符串;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-02-08 22:40
 */
public class 右旋字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        /*
        1. 翻转整个字符串
        2. 翻转前 k 个字符串
        3. 翻转后 n-k 个字符串
         */
        int n = s.length();
        if (k == 0 || k % n == 0) {
            return;
        }
        k = k % n;
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, s.length() - 1);
        reverseString(sb, 0, k - 1);
        reverseString(sb, k, s.length() - 1);
        System.out.println(sb.toString());
    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(end);
            sb.setCharAt(end, sb.charAt(start));
            sb.setCharAt(start, temp);
            start++;
            end--;
        }
    }
}
