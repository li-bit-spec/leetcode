package 算法.贪心算法;

public class 单调递增的数字 {
    public static int monotoneIncreasingDigits(int n) {
        // 将整数转换为字符串，再转为 StringBuilder
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int len = sb.length();
        System.out.println("len:"+len);
        // 从后往前遍历
        for (int i = len - 1; i > 0; i--) {
            // 获取当前字符和前一个字符
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i - 1);

            // 转换字符为数字
            int a1 = c1 - '0'; // 将字符转换为数字
            int a2 = c2 - '0'; // 将字符转换为数字

            // 如果当前字符小于前一个字符，进行修改
            if (a1 < a2) {
                sb.setCharAt(i - 1, (char)((a2-1)+'0'));
                for(int j = i;j<len;j++){
                    sb.setCharAt(j, '9');
                }
            }
        }
        System.out.println(sb.toString());
        // 将修改后的 StringBuilder 转回整数并返回
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {

        System.out.println(monotoneIncreasingDigits(332));
    }
}
