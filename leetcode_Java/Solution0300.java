// 300. 最长递增子序列


/*
动态规划：
1、题目简化：求数组的最长递增子序列的长度
2、定义dp数组：dp[i] 表示以索引i的元素结尾的最长递增子序列的长度
3、初始化：
  1）一维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）dp[i] = 1 表示每一个位置i的递增子序列的长度至少是1
4、状态转移方程：if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
  位置i的最长递增子序列长度 等于j从0到i-1各个位置的 最长递增子序列长度加1的 最大值
5、遍历dp数组填表：第一个for循环遍历dp数组的未知位置，第二个for循环遍历dp数组的已知位置，根据状态转移方程获取已知结果计算未知结果
6、返回结果：遍历时比较每个位置结尾时的最长递增子序列的长度，并记录最大值，最后返回最大值
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