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
动态规划：完全背包，二维数组
1、题目：给你一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。你可以认为每种硬币的数量是无限的。
2、题目简化：求凑成总金额amount所需的最少硬币数
3、定义dp数组：dp[i][j] 表示使用前i个硬币，凑成总金额j所需的最少硬币数
4、状态转移方程
  if (j - coins[i - 1] >= 0)  dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);   // 金额足够，“不用”和“用”两种情况比较出最少
  else  dp[i][j] = dp[i - 1][j];    // 金额不够，只能选择“不用”该硬币
  注意：dp[i - 1][j - coins[i - 1]] 表示第i个硬币只用一次，属于0-1背包。dp[i][j - coins[i - 1]] 表示第i个硬币重复使用，属于完全背包。
5、初始化：
  1）首列 dp[i][0] 表示使用前i个硬币，凑成总金额j所需的最少硬币数为0
  2）其他填充一个不可能的硬币数，使得不影响计算，也方便状态转移时取最小值
6、遍历dp数组填表：第一层遍历硬币，第二层遍历金额，都从1开始，正序遍历。两个for循环先后都可以，因为计算当前状态只需要当前行左边的状态和上一行的状态
7、返回结果：最后一个状态就是结果

二维dp更新过程，从左到右，从上到下
coins = [1, 2, 5], amount = 11
0  12  12  12  12  12  12  12  12  12  12  12
0  1   2   3   4   5   6   7   8   9   10  11
0  1   1   2   2   3   3   4   4   5   5   6
0  1   1   2   2   1   2   2   3   3   2   3
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (dp[n][amount] == amount + 1) ? -1 : dp[n][amount];
    }
}


/*
动态规划：完全背包，一维数组
1、定义dp数组：dp[i] 表示凑成总金额i所需的最少硬币数
2、状态转移方程：dp[i] = Math.min(dp[i], dp[i-coin]+1); 需要比较多种硬币情况下的最小值
3、初始化：
   dp[i]=amount+1; 填充一个不可能的硬币数，使得不影响计算，也方便状态转移时取最小值
   dp[0]=0; 表示凑成总金额0所需的最少硬币数为0，方便后面推导
4、遍历dp数组填表：
  1）第一个for循环遍历dp数组的未知位置，第二个for循环遍历硬币数组，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
  2）先物品再背包是计算组合，先背包再物品是计算排列，本题物品背包顺序无关，必须正序遍历背包才能重复使用物品
5、返回结果：最后一个状态就是结果

一维dp更新过程，从左到右
coins = [1, 2, 5], amount = 11
0  12  12  12  12  12  12  12  12  12  12  12
   1   2   3   4   5   6   7   8   9   10  11
       1   2   2   3   3   4   4   5   5   6
                   1   2   2   3   3   2   3
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}


/*
其他同上。遍历dp数组填表：第一个for循环遍历硬币数组，第二个for循环遍历dp数组的未知位置，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}