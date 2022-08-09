// 44. 数字序列中某一位的数字


/*
1、变量含义
  1）digit：每个数字的位数
  2）low：相同位数数字的区间起始值
  3）high：相同位数数字的区间终止值
  4）count：相同位数数字的区间内数字个数
2、算法过程
  1）初始化变量
  2）确定第n位所在的数字区间
  3）确定第n位实际对应的数字，即区间起始值加偏移个数
  4）确定对应数字的第几位，即偏移位数

        区间         每个数字位数digit  总位数count    n
    0到9 [0,10)            1            10        897
  10到99 [10,100)          2            180       887
100到999 [100,1000)        3            2700      707
num = 100 + 707/3 = 335
offset = 707 % 3 = 2
 */
public class Solution {
    public int findNthDigit (int n) {
        int digit = 1;
        long low = 0, high = 10, count = 10;
        while (n > count) {
            n -= count;
            low = high;
            high *= 10;
            digit++;
            count = (high - low) * digit;
        }
        int num = low + n / digit;
        int offset = n % digit;
        return String.valueOf(num).charAt(offset) - '0';
    }
}