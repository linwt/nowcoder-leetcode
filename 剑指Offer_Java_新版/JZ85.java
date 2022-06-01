// 85. 连续子数组的最大和(二)


/*
动态规划：
1、题目简化：求连续子数组最大和，并返回该子数组
2、在“42. 连续子数组的最大和”的基础上，记录每个元素结尾的最大和连续子数组的左右边界，
  当 子数组和更大 或者 子数组和相等的情况下区间更长，则更新 最大和 与 最终的区间边界
3、根据区间首尾获取子数组
 */
public class Solution {
    public int[] FindGreatestSumOfSubArray (int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int maxSum = dp[0];
        int left = 0, right = 0;
        int maxLeft = 0, maxRight = 0;
        for (int i = 1; i < n; i++) {
            right++;
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i - 1] + array[i] < array[i]) {
                left = right;
            }
            if (dp[i] > maxSum || (dp[i] == maxSum && right - left + 1 > maxRight - maxLeft + 1)) {
                maxSum = dp[i];
                maxLeft = left;
                maxRight = right;
            }
        }
        int len = maxRight - maxLeft + 1;
        int[] res = new int[len];
        System.arraycopy(array, maxLeft, res, 0, len);
        return res;
    }
}