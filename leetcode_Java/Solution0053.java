// 53. 最大子数组和


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
1、题目：给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
2、题目简化：求数组nums的具有最大和的连续子数组的和。要先求多个局部连续子数组的最大和，再从多个局部最大中得到全局最大
3、定义dp数组：dp[i]表示以索引i结尾的连续子数组的最大和
4、初始化：
  1）一维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）dp[0] = nums[0];
5、状态转移方程：dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
6、遍历dp数组填表：一个for循环遍历dp数组，根据状态转移方程推断计算未知结果并填表
7、返回结果：dp数组的最大值就是具有最大和的连续子数组的和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}