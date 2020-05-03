package HOT100;

import java.util.HashMap;

// 无重复字符的最长子串
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符重复，则更新起点
            if (map.containsKey(c))
                start = Math.max(start, map.get(c) + 1);
            // 更新当前字符索引
            map.put(c, i);
            // 计算当前最长子串
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}