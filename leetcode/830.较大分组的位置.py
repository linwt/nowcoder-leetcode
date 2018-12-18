# 遍历字符串，i记录起始索引，j记录终止索引，若两索引间距≥3，则将其索引区间添加到数组中
class Solution(object):
    def largeGroupPositions(self, S):
        j = 0
        res = []
        while j < len(S):
            i = j
            j += 1
            # j位置有值，并且与i位置值相等
            while j < len(S) and S[i] == S[j]:
                j += 1
            if j-i >= 3:
                res.append([i, j-1])
        return res