// 50. 第一个只出现一次的字符


public class Solution {
    // 数组实现
    public int FirstNotRepeatingChar(String str) {
        int[] array = new int[256];
        char[] chars = str.toCharArray();
        // 先统计全部字符个数
        for (int i = 0; i < str.length(); i++) {
            array[chars[i]]++;
        }
        // 再判断第一个出现一次的字符
        for (int i = 0; i < str.length(); i++) {
            if (array[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 字典实现
    public int FirstNotRepeatingChar2(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int time = map.get(c);
                map.put(c, ++time);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
