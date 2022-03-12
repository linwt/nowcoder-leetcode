// 322. 零钱兑换


/*
递归 + 备忘录
1、dfs(n)定义：输入目标金额n，返回凑出目标金额n的最少硬币数量
2、备忘录数组memo[n]表示凑出金额n的最少硬币数量，凑不出时最小值为-1，故初始化为-2
3、定义递归函数
    1）终止条件：目标金额为0返回0，目标金额为负数返回-1，目标金额在备忘录中有值则直接返回该值
    2）遍历硬币数组，调用递归函数，比较得到取不同面额的硬币时最少的硬币数量，记录结果并返回结果
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dfs(memo, coins, amount);
    }

    private int dfs(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = dfs(memo, coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}


/*
动态规划
1、题目：给你一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。你可以认为每种硬币的数量是无限的。
2、题目简化：求凑成总金额amount所需的最少硬币数
3、定义dp数组：dp[i] 表示凑成总金额i所需的最少硬币数
4、状态转移方程：dp[i] = Math.min(dp[i], dp[i-coin]+1); 需要比较多种硬币情况下的最小值
5、初始化：
   dp[i]=amount+1; 填充一个不可能的硬币数，使得不影响计算，也方便状态转移时取最小值
   dp[0]=0; 表示凑成总金额0所需的最少硬币数为0，方便后面推导
6、遍历dp数组填表：一个for循环遍历dp数组的未知位置，另一个for循环遍历硬币数组，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
7、返回结果：最后一个状态就是结果
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}