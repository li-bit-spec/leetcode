import java.util.List;
import java.util.Scanner;

/**
 * @author 李华宪
 * @Description 单词拆分（完全背包问题）
 * @create 2024-12-18 18:46
 */
public class _139 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");
        List<String> wordDict = List.of(arr);
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        /*
        完全背包问题(排列问题)
        把字符串s看作背包的容量
        单词数组看作物品的重量
        dp[j]为true 表示字符串 s 的前 j 个字符可以被拆分成一个或多个在字典中出现的单词。
        递推公式： dp[j] = dp[j-wordDict.get(i).length()] && wordDict.contains(s.substring(j-wordDict.get(i).length(), j))
        表示：如果 dp[j-wordDict.get(i).length()] 为 true 并且 s.substring(j-wordDict.get(i).length(), j) 在 wordDict 中，那么 dp[j] 为 true
         */
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // 遍历字符串 s 并更新 dp 数组
        for (int j = 1; j <= n; j++) {
            // 遍历字典中所有单词并检查 s[j-wordDict[i].length(), j] 是否在字典中
            for (int i = 0; i < wordDict.size(); i++) {
                if (j >= wordDict.get(i).length()) {
                    // dp[j] 被覆盖: 你在内层循环中每次都会更新 dp[j]
                    // 但是由于内层循环是针对字典中所有单词进行的，每次都会覆盖之前的 dp[j] 值，这可能导致某些有效的拆分被错误地覆盖成 false
                    dp[j] = dp[j] || (dp[j - wordDict.get(i).length()] && wordDict.contains(s.substring(j - wordDict.get(i).length(), j)));
                }
            }
        }
        return dp[n];
    }
}
