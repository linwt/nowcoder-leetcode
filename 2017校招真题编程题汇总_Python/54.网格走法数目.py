# 动态规划：
# 对于x*Y网格，dp[i][j]表示(i,j)位置一共有多少种走法,
# 由于只能向右和向下走，所以第一列和第一行所有位置的走法都是1，即dp[i][0]=1,dp[0][j]=1，
# 对于其他位置，走法应该等于其左边格点的走法与其上面格点的走法之和，dp[i][j]=dp[i-1][j]+dp[i][j-1]

row, col = map(int, raw_input().split())
result = [[1 for _ in range(col)] for _ in range(row)]
for i in range(row):
    for j in range(col):
        result[i][j] = result[i-1][j] + result[i][j-1]
print(result[-1][-1])