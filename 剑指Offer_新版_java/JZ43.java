// 43. 整数中1出现的次数（从1到n整数中1出现的次数）


public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n > 0) {
            String num = String.valueOf(n);
            char[] array = num.toCharArray();
            for (char c : array) {
                if (c == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}
