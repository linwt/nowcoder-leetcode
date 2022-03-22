// 647. 回文子串


/*
与“5.最长回文子串”相似
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    res++;
                }
            }
        }
        return res;
    }
}