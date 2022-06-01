// 83. 剪绳子(进阶版)


/*
在“14. 剪绳子”的基础上，对结果取余
 */
public class Solution {
    public long cutRope (long number) {
        if (number == 2 || number == 3) {
            return number - 1;
        }
        long mod = 998244353;
        long res = 1;
        while (number > 4) {
            number -= 3;
            res *= 3;
            res %= mod;
        }
        return res * number % mod;
    }
}


public class Solution {
    public long cutRope (long number) {
        if (number == 2 || number == 3) {
            return number - 1;
        }
        long x = number % 3;
        long y = number / 3;
        if (x == 1) {
            return (long) Math.pow(3, y - 1) * 4 % mod;
        } else if (x == 2) {
            return (long) Math.pow(3, y) * 2 % mod;
        } else {
            return (long) Math.pow(3, y) % mod;
        }
    }
}


/*
快速幂：以上解法都太慢了
1、公式
  1）b是偶数：a的b次方 = (a*a)的(b/2)次方
  2）b是奇数：a的b次方 = (a*a)的(b/2)次方 * a
2、计算逻辑，每次循环幂减一半、基数翻倍，幂为奇数时结果乘基数

    num  res  base
初始  5    1    3
结果  5    3    9
     2    9    81
     1    81   6561
 */
public class Solution {
    long mod = 998244353;

    public long cutRope (long number) {
        if (number == 2 || number == 3) {
            return number - 1;
        }
        long x = number % 3;
        long y = number / 3;
        if (x == 1) {
            return pow(3, y - 1) * 4 % mod;
        } else if (x == 2) {
            return pow(3, y) * 2 % mod;
        } else {
            return pow(3, y) % mod;
        }
    }

    private long pow(long base, long num) {
        long res = 1;
        while (num > 0) {
            if (num % 2 == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            num /= 2;
        }
        return res;
    }
}