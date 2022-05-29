# 找最小重叠部分的行列数相乘
class Solution(object):
    def maxCount(self, m, n, ops):
        for op in ops:
            if op[0] < m:
                m = op[0]
            if op[1] < n:
                n = op[1]
        return m*n