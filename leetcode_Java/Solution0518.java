// 518. 零钱兑换 II


/*
动态规划：
1、题目：给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。假设每一种面额的硬币有无限个。
2、题目简化：求凑成总金额amount的硬币组合数
3、定义dp数组：dp[i] 表示凑成总金额i的硬币组合数
4、状态转移方程：dp[i] += dp[i-coin]，即所有dp[i-coin]相加
5、初始化：dp[0] = 1，表示凑成总金额0的硬币组合数为1，方便后面推导
6、遍历dp数组填表：一个for循环遍历dp数组的未知位置，另一个for循环遍历硬币数组，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
   1）外层for循环遍历硬币，内层for遍历金额，这种遍历顺序中dp[i]里计算的是组合数
   2）外层for循环遍历金额，内层for遍历硬币，这种遍历顺序中dp[i]里计算的是排列数
7、返回结果：最后一个状态就是结果
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}


/*
回溯：
1、因为可重复使用，所以当前层选择元素后，下一层的可选剩余集合就是包括当前元素的后半部分剩余集合，防止产生重复组合
2、定义递归函数
    1）终止条件，总和等于目标值，存储子结果
    2）剪枝条件，总和大于目标值，结束
    3）for循环遍历数组，做选择 → 递归 → 撤销选择，回溯
 */
class Solution {
    private int res = 0;

    public int change(int amount, int[] coins) {
        backtrack(0, 0, amount, coins);
        return res;
    }

    private void backtrack(int count, int startIndex, int amount, int[] coins) {
        if (count == amount) {
            res++;
            return;
        }
        if (count > amount) {
            return;
        }
        for (int i = startIndex; i < coins.length; i++) {
            backtrack(count + coins[i], i, amount, coins);
        }
    }
}