// 300. 最长递增子序列


/*
1、定义dp数组：dp[i] 表示以索引i的元素结尾的最长递增子序列的长度
2、状态转移方程：if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
  位置i的最长递增子序列长度 等于j从0到i-1各个位置的 最长递增子序列加1的 最大值
3、初始化：dp[i] = 1 表示每一个位置i的递增子序列的长度至少是1
4、遍历dp数组填表：第一个for循环遍历dp数组的未知位置，第二个for循环遍历dp数组的已知位置，根据状态转移方程获取已知结果计算未知结果
5、返回结果：遍历时比较每个位置结尾时的最长递增子序列的长度，并记录最大值，最后返回最大值
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}