# 数组排序后分成两部分，前一部分全部加K，后一部分全部减K
# 取出两部分的第一个元素的更小者，最后一个元素的更大者，得到变化后的数组的最大最小值
class Solution(object):
    def smallestRangeII(self, A, K):
        n = len(A)
        if n < 2:
            return 0
        A.sort()
        res = A[n-1] - A[0]
        for i in range(1, n):
            minu = min(A[0] + K, A[i] - K)
            maxu = max(A[i-1] + K, A[n-1] - K)
            res = min(res, maxu - minu)
        return res