// 67. 把字符串转换成整数(atoi)


/*
1、遍历去掉空格
2、判断是否有+-符号，有则记录sign
3、遍历数字，如果算上当前数字后超过整型最大值，则根据sign标志直接返回结果，否则更新结果将当前数字加入最低位
  if语句另一写法 if ((long) res * 10 + digit > Integer.MAX_VALUE) {}
4、根据sign标志返回结果
 */
class Solution {
    public int myAtoi(String s) {
        int n = s.length(), res = 0, index = 0, sign = 1;
        char[] array = s.toCharArray();
        while (index < n && array[index] == ' ') {
            index++;
        }
        if (index < n && (array[index] == '-' || array[index] == '+')) {
            sign = array[index++] == '-' ? -1 : 1;
        }
        while (index < n && array[index] >= '0' && array[index] <= '9') {
            int digit = array[index++] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return res * sign;
    }
}


public class Solution {
    public int StrToInt(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
