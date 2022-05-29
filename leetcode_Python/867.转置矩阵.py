# 先初始化结果矩阵的行列，再将值代入
class Solution(object):
    def transpose(self, A):
        row = len(A)
        col = len(A[0]) if row else 0
        res = [[0]*row for j in range(col)]
        for i in range(row):
            for j in range(col):
                res[j][i] = A[i][j]
        return res

# *A代表解压缩
class Solution(object):
    def transpose(self, A):
        return [i for i in zip(*A)]