# 动态规划，原地修改，自底向上，记录每个位置的最短路径
class Solution(object):
    def minimumTotal(self, triangle):
        for i in range(len(triangle)-2, -1, -1):
            for j in range(i+1):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]


# 自底向上，使用一维数组记录最短路径状态
class Solution2(object):
    def minimumTotal(self, triangle):
        # 加1不用初始化最后一层
        dp = [0] * (len(triangle)+1)
        for i in range(len(triangle)-1, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
        return dp[0]


# 自顶向下，原地修改
class Solution3(object):
    def minimumTotal(self, triangle):
        for i in range(1, len(triangle)):
            for j in range(i+1):
                # 行首元素
                if j == 0:
                    triangle[i][j] += triangle[i-1][j]
                # 行尾元素
                elif j == len(triangle[i])-1:
                    triangle[i][j] += triangle[i-1][j-1]
                # 内部元素
                else:
                    triangle[i][j] += min(triangle[i-1][j], triangle[i-1][j-1])
        return min(triangle[-1])