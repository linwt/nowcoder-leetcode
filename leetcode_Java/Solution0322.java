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
1、dp[n]表示目标金额n的最少硬币数量
2、遍历dp数组，根据状态转移方程填充元素
3、此处dp[i]并非一次性填充，要遍历硬币数组，在多种选择下获取最小值填充
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
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