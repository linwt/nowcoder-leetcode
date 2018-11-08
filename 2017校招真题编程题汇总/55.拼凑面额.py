# 完全背包问题。与34题比较。
N = int(raw_input())
dp = [1]*(N+1)
for c in [5, 10, 20, 50, 100]:
    # 硬币足够多，顺着计算，累加前面的结果
    for i in range(c, N+1):
        dp[i] += dp[i-c]
print(dp[-1])