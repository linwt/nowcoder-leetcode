# 动态规划，自顶向下，原地改动，A[i][j]记录当前位置最小路径和
class Solution(object):
    def minFallingPathSum(self, A):
        for i in range(1, len(A)):
            for j in range(len(A)):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                elif j == len(A)-1:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1])
                else:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1], A[i-1][j-1])
        return min(A[-1])


