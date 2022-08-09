// 198. 打家劫舍


/*
动态规划：
1、定义dp数组：dp[i] 表示在第i号房屋时能偷窃到的最高金额
2、初始化：
  1）dp[0]=0 表示没有偷窃时金额为0，dp[1]=nums[0] 表示第1号房屋时偷窃最高金额为nums[0]
  2）因为状态转移方程由前两项推出，所以要先初始化前两项
3、状态转移方程：
  1）如果偷窃第i号房屋，那么i-1号房屋不能偷窃，则最高金额为 dp[i - 2] + nums[i - 1]
  2）如果不偷窃第i号房屋，那么最高金额同i-1号房屋一样，即 dp[i - 1]
  3）在 偷窃 和 不偷窃 选择最高金额，即 dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
4、遍历dp数组填表：从索引2开始遍历，根据状态转移方程填表
5、返回结果：最后一个状态就是结果
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}


/*
状态压缩：由于dp数组只用到前两项，所以用两个变量替代即可，表示前两个房屋能偷窃到的最高金额，动态更新两个变量的值
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int pre = 0, cur = nums[0];
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i - 1]);
            pre = temp;
        }
        return cur;
    }
}