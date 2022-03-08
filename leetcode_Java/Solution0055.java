// 55. 跳跃游戏


/*
动态规划：
1、dp[i]定义：表示在索引为 i 的位置能够跳跃到的最远距离
2、状态转移方程：dp[i] = max(dp[i - 1], i + nums[i])
3、在状态转移前后进行跳跃长度判断以快速得出结果，没希望跳过去、已经足够跳过去
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