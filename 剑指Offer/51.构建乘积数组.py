# 不要将索引相同的元素算进因子即可
class Solution:
    def multiply(self, A):
        n = len(A)
        B = [1]*n
        for i in range(n):
            for j in range(n):
                if i != j:
                    B[i] *= A[j]
        return B