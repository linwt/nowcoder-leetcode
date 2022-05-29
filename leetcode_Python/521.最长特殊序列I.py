# 任何字符串为其自身的子序列
class Solution(object):
    def findLUSlength(self, a, b):
        if a==b:
            return -1
        return max(len(a), len(b))