# 颠倒两个字符串区间的位置
class Solution:
    def LeftRotateString(self, s, n):
        return s[n:] + s[:n]