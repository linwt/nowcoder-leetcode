// 14. 最长公共前缀


/*
横向比较：
1、当字符串数组长度为 0 时则公共前缀为空，直接返回
2、令第一个字符串为最长公共前缀，进行初始化
3、第一个for循环遍历数组，第二个while循环遍历字符
  即横向比较，遍历后面的字符串，依次将其与第一个字符串进行比较，两两找出公共前缀并截取第一个字符串，最终结果即为最长公共前缀
4、如果查找过程第一个字符串截取后为空，则后面的字符串不用判断了，直接返回
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 1; i < n; i++) {
            int j = 0;
            String curStr = strs[i];
            while (j < firstStr.length() && j < curStr.length() && firstStr.charAt(j) == curStr.charAt(j)) {
                j++;
            }
            firstStr = firstStr.substring(0, j);
            if (firstStr.equals("")) {
                return firstStr;
            }
        }
        return firstStr;
    }
}


/*
纵向比较：
1、当字符串数组长度为 0 时则公共前缀为空，直接返回
2、第一个for循环遍历字符，第二个for循环遍历数组。即纵向比较同一位置上 其他字符串的字符 是否与 第一个字符串的字符 相同
  相同则继续往后判断，遍历结束表示全部相同，返回第一个字符串
  越界或不同则结束判断，然后第一个字符串截取出最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        String firstStr = strs[0];
        int m = firstStr.length();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                String curStr = strs[j];
                if (i == curStr.length() || curStr.charAt(i) != firstStr.charAt(i)) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}