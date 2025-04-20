package 算法.栈与队列;

import java.util.Stack;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-02 22:21
 */
public class 逆波兰表达式求值 {
    public static void main(String[] args) throws Exception {
        String expression = "3 4 + 5 *";
        String[] tokens = expression.split("\\s+");
        System.out.println(evaluateRPN(tokens));
    }

    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> stackInteger = new Stack<Integer>();
//        Stack<Character> stackCharacter = new Stack<Character>();
        for (String token : tokens) {
            char c = token.charAt(0);
            // 注意处理负数的情况
            if (Character.isDigit(c) || (token.length() > 1 && c == '-')) {
                stackInteger.push(Integer.parseInt(token));
            } else if (c == '+') {
                int a = stackInteger.pop();
                int b = stackInteger.pop();
                stackInteger.push(b + a);
            } else if (c == '-') {
                int a = stackInteger.pop();
                int b = stackInteger.pop();
                stackInteger.push(b - a);
            } else if (c == '*') {
                int a = stackInteger.pop();
                int b = stackInteger.pop();
                stackInteger.push(b * a);
            } else if (c == '/') {
                int a = stackInteger.pop();
                int b = stackInteger.pop();
                stackInteger.push(b / a);
            }
        }
        return stackInteger.pop();
    }
}
