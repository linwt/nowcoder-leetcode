// 58. 左旋转字符串


public class Solution {
    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (n > len) {
            return str;
        }
        return str.substring(n, len) + str.substring(0, n);
    }
}
