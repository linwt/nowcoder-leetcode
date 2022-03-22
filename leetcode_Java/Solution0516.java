// 516. 最长回文子序列


class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), res = 1;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int r = 1; r < n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l == 1) {
                        dp[l][r] = 2;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1] + 2;
                    }
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
                res = Math.max(res, dp[l][r]);
            }
        }
        return res;
    }
}