// 48. 最长不含重复字符的子字符串
//同“3. 无重复字符的最长子串”（力扣）


/*
索引定位收缩左区间：
1、HashMap保存滑动窗口中的字符的索引
2、如果右指针移动过程新的字符 出现 在滑动窗口中，则更新左指针位置
3、更新当前字符在HashMap中的索引
4、右指针每移动一次后，计算新窗口的长度，比较并保存最大长度
 */
public class Solution {
    public int lengthOfLongestSubstring (String s) {
        int maxLen = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}


/*
左指针右移收缩左区间：
1、HashMap保存滑动窗口中的字符的出现次数
2、如果右指针移动过程新的字符 没有 在滑动窗口中，则将字符添加到HashMap中，次数记为1
3、如果右指针移动过程新的字符 出现 在滑动窗口中，则移动左指针直到同样该字符的下一位，移动过程指向的字符在HashMap中出现次数减1
4、右指针每移动一次后，计算新窗口的长度，比较并保存最大长度
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.getOrDefault(c, 0) == 0) {
                map.put(c, 1);
            } else {
                while (s.charAt(start) != c) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) -1);
                    start++;
                }
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}