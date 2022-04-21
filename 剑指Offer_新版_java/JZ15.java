// 15. 二进制中1的个数


public class Solution {
    public int NumberOf1(int n) {
        if (n == 0) return 0;
        int num = 0;
        while (n != 0) {
            num++;
            n = n & (n - 1);
        }
        return num;
    }

    public int NumberOf12(int n) {
        char[] ch = Integer.toBinaryString(n).toCharArray();
        int num = 0;
        for (char c : ch) {
            if (c == '1') num++;
        }
        return num;
    }
}