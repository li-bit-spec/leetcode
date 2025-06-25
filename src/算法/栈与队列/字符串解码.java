package 算法.栈与队列;
import java.util.*;

public class 字符串解码 {
    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "2[abc]3[cd]ef";
        String s3 = "abc3[cd]xyz";
        String s4 = "2[a2[bc]]";  // 嵌套情况
        
        System.out.println("输入: " + s1 + " -> 输出: " + decodeString(s1));
        System.out.println("输入: " + s2 + " -> 输出: " + decodeString(s2));
        System.out.println("输入: " + s3 + " -> 输出: " + decodeString(s3));
        System.out.println("输入: " + s4 + " -> 输出: " + decodeString(s4));
    }
    
    /**
     * 字符串解码 - 使用双栈解法（更易理解）
     * 思路：
     * 1. 使用两个栈：数字栈存储重复次数，字符串栈存储当前处理的字符串
     * 2. 遇到数字：累积数字值
     * 3. 遇到'['：将当前数字和字符串分别压入栈，重置当前变量
     * 4. 遇到']'：弹出栈顶，进行字符串重复操作
     * 5. 遇到字母：直接添加到当前字符串
     */
    private static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();    // 存储数字
        Stack<String> strStack = new Stack<>();     // 存储字符串
        
        int num = 0;                                // 当前处理的数字
        String currentStr = "";                     // 当前处理的字符串
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 处理数字（可能是多位数）
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到'['，保存当前状态到栈中
                numStack.push(num);
                strStack.push(currentStr);
                // 重置当前状态
                num = 0;
                currentStr = "";
            } else if (c == ']') {
                // 遇到']'，开始解码
                int repeatTimes = numStack.pop();      // 获取重复次数
                String previousStr = strStack.pop();   // 获取之前的字符串
                
                // 重复当前字符串指定次数
                StringBuilder sb = new StringBuilder(previousStr);
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(currentStr);
                }
                currentStr = sb.toString();
            } else {
                // 普通字母，直接添加到当前字符串
                currentStr += c;
            }
        }
        
        return currentStr;
    }
}
