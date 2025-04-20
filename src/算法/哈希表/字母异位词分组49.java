package 算法.哈希表;

import java.util.*;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-05 15:12
 */
public class 字母异位词分组49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);

    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = charArray.toString();
            List<String> list = new ArrayList<>();
            if (map.containsKey(s)) {
                list = map.get(s);
            }
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
}
