// 爬楼梯


/*
递推思路：
1、规律：1,2,3,5,8  后一个数是前两个数的和
2、初始化两个值，根据规律逐渐推算出第n个数的值
 */
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        int temp;
        while (n > 1) {
            temp = b;
            b += a;
            a = temp;
            n -= 1;
        }
        return b;
    }
}


/*
动态规划思路：
1、dp[i]表示i阶楼梯的方法数量
2、初始条件：dp[0] = dp[1] = 1
3、状态转移方程：dp[i] = dp[i - 1] + dp[i - 2]
 */
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}