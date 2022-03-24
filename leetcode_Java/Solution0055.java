// 55. 跳跃游戏


/*
动态规划：
1、题目：给定一个非负整数数组nums，你最初位于数组的第一个下标，数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你是否能够到达最后一个下标。
2、题目简化：求索引 i 位置可以跳跃的最大长度，该长度是否大于等于最后一个索引位置
3、定义dp数组：dp[i]表示索引 i 位置能够跳跃到的最大长度
4、初始化：
  1）dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）dp[0] = nums[0];
5、状态转移方程：dp[i] = max(dp[i - 1], i + nums[i]);
6、遍历dp数组填表：一个for循环遍历dp数组，根据状态转移方程推断计算未知结果并填表
7、返回结果：在状态转移前后进行跳跃长度判断以快速得出结果，没希望跳过去、已经足够跳过去
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] >= n - 1) {
                return true;
            }
        }
        return true;
    }
}


/*
贪心/动态规划状态压缩：只用一个变量存储可以跳跃的最远距离，省略整个dp数组的空间
1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
3、如果可以一直跳到最后，就成功了
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen < i) {
                return false;
            }
            maxLen = Math.max(maxLen, i + nums[i]);
        }
        return true;
    }
}