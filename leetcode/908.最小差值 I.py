# 添加新元素后最小差缩小了2k，若减去2k结果为正则为最终答案，否则为0
class Solution(object):
    def smallestRangeI(self, A, K):
        return max(max(A) - min(A) - 2*K, 0)