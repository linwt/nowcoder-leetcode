// 最长上升子序列


public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;

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