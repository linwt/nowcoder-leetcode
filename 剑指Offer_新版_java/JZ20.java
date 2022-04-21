// 20. 表示数值的字符串


public class Solution {
    public boolean isNumeric(char[] str) {
        try {
            Float.parseFloat(new String(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}