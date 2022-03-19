// 518. 零钱兑换 II


/*
动态规划：完全背包，二维数组
1、题目：给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。假设每一种面额的硬币有无限个。
2、题目简化：求凑成总金额amount的硬币组合数
3、定义dp数组：dp[i][j] 表示使用前i个硬币，凑成总金额j的硬币组合数
4、状态转移方程
  if (j - coins[i - 1] >= 0)  dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];    // 金额足够，“不用”和“用”两种情况相加
  else  dp[i][j] = dp[i - 1][j];    // 金额不够，只能选择“不用”该硬币
  注意：dp[i - 1][j - coins[i - 1]] 表示第i个硬币只用一次，属于0-1背包。dp[i][j - coins[i - 1]] 表示第i个硬币重复使用，属于完全背包。
5、初始化：首行首列
  dp[i][0] = 1 表示使用前i个硬币，凑成总金额0的硬币组合数为1，即不用硬币就能凑成
  dp[0][j] = 0 表示使用前0给硬币，凑成总金额j的硬币组合数为0，即没有硬币可以凑成。创建dp数组时已经有默认值
6、遍历dp数组填表：第一层遍历硬币，第二层遍历金额，都从1开始，正序遍历。两个for循环先后都可以，因为计算当前状态只需要当前行左边的状态和上一行的状态
7、返回结果：最后一个状态就是结果

二维dp更新过程，从左到右，从上到下
amount = 5, coins = [1, 2, 5]
1  0  0  0  0  0
1  1  1  1  1  1
1  1  2  2  3  3
1  1  2  2  3  4
 */
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}


/*
动态规划：完全背包，一维数组
1、定义dp数组：dp[i] 表示凑成总金额i的硬币组合数
2、状态转移方程：dp[i] = dp[i] + dp[i-coin]，即所有dp[i-coin]相加
3、初始化：dp[0] = 1，表示凑成总金额0的硬币组合数为1，即不用硬币，方便后面推导
4、遍历dp数组填表：
   1）遍历顺序：
     ① 第一个for循环遍历硬币数组，第二个for循环遍历dp数组的未知位置，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
     ② 先物品再背包是计算组合，先背包再物品是计算排列，必须正序遍历背包才能重复使用物品
   2）遍历理解
     ① 一维数组是滚动数组，每一轮滚动遍历中，未遍历的表示上一轮的旧状态，正在遍历的表示正在计算的状态，遍历过的表示本轮的新状态
     ② 本轮遍历中，金额不够时，只能选择不用硬币，旧状态就是“不用”，所以只遍历金额足够的情况即可(i = coin 开始)
5、返回结果：最后一个状态就是结果

一维dp更新过程，从左到右
amount = 5, coins = [1, 2, 5]
1  1  1  1  1  1
      2  2  3  3
               4
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