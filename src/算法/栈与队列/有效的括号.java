package 算法.栈与队列;

import java.util.Stack;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-02 21:47
 */
public class 有效的括号 {
    public static void main(String[] args) throws Exception {
        String s = "[(](())})]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        if (n == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
//            else {
//                stack.pop();
//            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
