# 使第一列全为1，其他列1要比0多
class Solution(object):
    def matrixScore(self, A):
        res, m, n = 0, len(A), len(A[0])
        for i in range(m):
            if A[i][0] == 0:
                for j in range(n):
                    if A[i][j] == 0:
                        A[i][j] = 1
                    else:
                        A[i][j] = 0
        res = m * pow(2, n-1)
        for j in range(1, n):
            count = 0
            for i in range(m):
                if A[i][j] == 1:
                    count += 1
            if count <= m/2:
                count = m - count
            res += count * pow(2, n-1-j)
        return res