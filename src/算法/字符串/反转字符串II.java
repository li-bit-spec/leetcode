package 算法.字符串;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-23 14:13
 */
public class 反转字符串II {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        reverseStr(s, k);
        System.out.println(s);
    }

    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int a = n / (2 * k);
        int b = n % (2 * k);
        for (int i = 0; i < a; i++) {
            int left = i * 2 * k + k - 1;
            int right = i * 2 * k + k;
            while (left >= i * 2 * k) {
                sb.append(s.charAt(left));
                left--;
            }
            while (right < i * 2 * k + k + k) {
                sb.append(s.charAt(right));
                right++;
            }
        }
        if (b <= k) {
            int left = n - 1;
            while (left >= a * 2 * k) {
                sb.append(s.charAt(left));
                left--;
            }
        } else {
            int left = a * 2 * k + k - 1;
            while (left >= a * 2 * k) {
                sb.append(s.charAt(left));
                left--;
            }
            int right = a * 2 * k + k;
            while (right < n) {
                sb.append(s.charAt(right));
                right++;
            }
        }
        return sb.toString();
    }

}
