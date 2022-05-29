# 动态规划：1、大问题分解成小问题    2、重复利用之前的计算结果

# dp[i][j]存放以s[i]开头、s[j]结尾的子串的最长回文子序列长度
# 先计算相邻两个字符的最长回文长度，利用前面的结果再计算相邻三个字符，以此类推得到整个字符串的结果
class Solution(object):
    def longestPalindromeSubseq(self, s):
        n = len(s)
        dp = [[0]*n for _ in range(n)]
        # 初始化数组
        for i in range(n):
            dp[i][i] = 1
        for j in range(1, n):
            for i in range(j-1, -1, -1):
                if s[i] == s[j]:
                    # 回文串每次增加2个字符，所以需要在上一状态加2
                    dp[i][j] = dp[i+1][j-1] + 2
                else:
                    # 若不相等则需要在其两个最长子串中比较出回文子序列长度较大者
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        return dp[0][-1]
# g 1 2 4 4 4
# 0 o 2 2 2 2
# 0 0 o 1 1 1
# 0 0 0 g 1 1
# 0 0 0 0 l 1
# 0 0 0 0 0 e



# 转化为求s和s[::-1]的最长公共子序列
# dp[i][j]表示t子串增加字符t[i]、s子串增加字符s[j]后，两者最长公共子序列的长度
class Solution2(object):
    def longestPalindromeSubseq(self, s):
        if s == s[::-1]:
            return len(s)
        n = len(s)
        t = s[::-1]
        dp = [[0]*(n+1) for _ in range(n+1)]
        for i in range(n):
            for j in range(n):
                if t[i] == s[j]:
                    # 两字符相等，则当前状态为前一状态加1
                    dp[i+1][j+1] = dp[i][j] + 1
                else:
                    # 两字符不相等，则比较没有哪个字符时长度较大
                    dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1])
        return dp[-1][-1]
#      g o o g l e
#    0 0 0 0 0 0 0
# e  0 0 0 0 0 0 1
# l  0 0 0 0 0 1 1
# g  0 1 1 1 1 1 1
# o  0 1 2 2 2 2 2
# o  0 1 2 3 3 3 3
# g  0 1 2 3 4 4 4
