// 338. 比特位计数


/*
动态规划：
i为偶数时，f(i)=f(i/2)，因为i/2本质上是i的二进制左移一位，低位补零，所以1的数量不变
i为奇数时，f(i)=f(i-1)+1，因为i-1为偶数，而偶数的二进制最低位一定是0，偶数加1后最低位变为1且不会进位
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp;
    }
}


/*
逻辑同上，“与”写法。i&1结果偶数为0，奇数为1
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + (i & 1);
        }
        return dp;
    }
}


/*
1、直接计算每个数的二进制中1的个数
2、n &= n - 1，该运算将 n 的二进制表示的最后一个 1 变成 0，操作几次说明有几个1
 */
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    private int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}