// 415. 字符串相加


/*
模拟竖式加法，从最低位开始两数相加，和超过10则向高位进一位，其中一个数字遍历结束了则需要补0
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res.append(sum % 10);
        }
        return res.reverse().toString();
    }
}