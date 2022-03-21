// 674. 最长连续递增序列


/*
动态规划：
题目简化：求数组的最长连续递增子序列的长度
1、定义dp数组：dp[i] 表示以索引i的元素结尾的最长连续递增子序列的长度
2、初始化：dp[i] = 1 表示每一个位置i的连续递增子序列的长度至少是1
3、状态转移方程：if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
  位置i的最长连续递增子序列长度 等于前一位置的最长连续递增子序列长度加1
4、遍历dp数组填表：一个for循环遍历dp数组的未知位置，根据状态转移方程获取已知结果计算未知结果
5、返回结果：遍历时比较每个位置结尾时的最长连续递增子序列的长度，并记录最大值，最后返回最大值
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}


/*
贪心：双指针，遍历数组，记录起始位置，当前元素比前一元素大时 计算连续递增子序列的长度 并保存最大值，否则将当前位置重新作为起始位置，最终返回最长连续递增子序列的长度
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res = Math.max(res, i - start + 1);
            } else {
                start = i;
            }
        }
        return res;
    }
}


/*
贪心：变量计数
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res = Math.max(res, ++count);
            } else {
                count = 1;
            }
        }
        return res;
    }
}