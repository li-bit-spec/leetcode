package 算法.字符串;

import java.util.Scanner;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-24 00:21
 */
public class 替换数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(replaceNum(input));
    }

    public static String replaceNum(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append('n').append('u').append('m').append('b').append('e').append('r');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
