package 算法.字符串;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-24 01:27
 */
public class 翻转字符串中的单词 {
    public static void main(String[] args) {
        String s = "  hello  world  ";
        reverseWords(s);
    }

    private static String reverseWords(String s) {
        // 双指针
        /*
         * 1. 去除多余空格
         * 2. 翻转整个字符串
         * 3. 翻转单个字符串 (双指针)
         */
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
//       System.out.println(sb.toString());
//       System.out.println(sb.toString().length());
        reverseEachWord(sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }
            start++;
        }
        return sb;
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

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
