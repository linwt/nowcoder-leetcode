# 每次将数组最小值取反替换
class Solution(object):
    def largestSumAfterKNegations(self, A, K):
        for _ in range(K):
            num = min(A)
            i = A.index(num)
            A[i] = -num
        return sum(A)