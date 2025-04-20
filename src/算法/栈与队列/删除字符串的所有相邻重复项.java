package 算法.栈与队列;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-02 22:12
 */
public class 删除字符串的所有相邻重复项 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(removeDuplicates(input));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        // 需要将栈中的字符串反过来
        Stack<Character> stackOut = new Stack<>();
        while (!stack.isEmpty()) {
            stackOut.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stackOut.isEmpty()) {
            sb.append(stackOut.pop());
        }
        return sb.toString();
    }
}
