// 29. 两数相除


/*
二分查找：
1、题目限定了不能使用乘法、除法和 mod 运算符
2、通过位运算实现一个「倍增乘法」
3、对于x除以y，结果 x/y 必然落在范围 [0,x] 内，对该范围进行二分查找
4、数字太大时计算可能溢出，所以全部用long类型，最终结果再转成int类型
5、处理标记结果正负号，运算过程用正数，最后再添加正负号
6、计算中点位置时 (left + rigth + 1) / 2 的原因，假设最终剩下两个数
  1）(left + rigth + 1) / 2 会使中点位于右边的数，当右边的数乘积大于被除数时，会收缩右边界，最后只剩下左边的数，左边的数刚好是商取整的值
  2）(left + rigth) / 2 会使中点位于左边的数，当左边的数乘积小于被除数时，会收缩左边界，但是中点和左边界在同一位置上，所以会陷入死循环
7、收缩边界
  1）中点乘积 <= 被除数时，收缩左边界，由于中点乘积是小于，中点可能是目标值，所以要包括中点，即 left = mid
  2）中点乘积 > 被除数时，收缩右边界，由于中点乘积是大于，中点不可能是目标值，所以不用包括中点，即 rigth = mid - 1
 */
class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            isNeg = true;
        }
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        long left = 0, rigth = x;
        while (left < rigth) {
            long mid = (left + rigth + 1) / 2;
            if (multiply(mid, y) <= x) {
                left = mid;
            } else {
                rigth = mid - 1;
            }
        }
        long res = isNeg ? -left : left;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    private long multiply(long a, long b) {
        long res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res += a;
            }
            b >>= 1;
            a += a;
        }
        return res;
    }
}