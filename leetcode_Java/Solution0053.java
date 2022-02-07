// 最大子数组和


/*
贪心思路：
1、遍历数组，当前元素的 之前和大于0 时，则加上当前值得到当前和，这样累加值才会更大，否则将当前值赋给当前和
2、当前和只是一个中间变量，记录过程中每个局部最大和。比较历史最大值 和 当前和，得到较大值
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}


/*
贪心思路：
1、核心思路都是判断以前一个元素结尾的子序列的最大值能不能给当前元素结尾的序列提供增益
2、如果之前和为负数就不能提供增益，加上当前元素后会比当前元素小，因此通过比较大小就能获得当前和的最大值
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}


/*
动态规划思路：
1、dp[i]表示以i结尾子串的最大值
2、初始条件：dp[0] = nums[0]
3、状态转移方程：
    if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
    else dp[i] = nums[i];
4、从dp数组中每个局部最大值获取全局最大值
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}