// 392. 判断子序列


/*
求字符串t是否为字符串s的子序列，实际就是“1143.最长公共子序列”，得到最长长度再判断是否等于t的长度
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m] == n ? true : false;
    }
}


/*
双指针：两个指针分别指向字符串s和t，当两个指针指向的字符相等时 i指针才向右移动一步，j指针每次都向右移动一步，只要其中一个字符串遍历完就结束，
      最后判断i指针是否到了末尾，是则表示s是t的子序列，否则不是
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n ? true : false;
    }
}