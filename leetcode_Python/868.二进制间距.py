# 边遍历边统计每个间距的长度，更新最大间距
class Solution(object):
    def binaryGap(self, N):
        n = bin(N)[2:]
        res, count, i = 0, 1, 1
        while i < len(n):
            if n[i] == '1':
                res = max(res, count)
                count = 1
                i += 1
            else:
                count += 1
                i += 1
        return res