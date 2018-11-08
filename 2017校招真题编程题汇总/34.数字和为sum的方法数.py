# 01背包问题。与55题比较
# 写法一
n, m = map(int, raw_input().split())
a = map(int, raw_input().split())
dp = [0]*(m+1)
dp[0] = 1
for i in a:
    # 数字只能用一次，需要逆着计算，不会累加到前面结果
    for j in range(m, i-1, -1):
        dp[j] += dp[j-i]
print(dp[m])

# 写法二
n, m = map(int, raw_input().split())
a = map(int, raw_input().split())
dp = [0]*(m+1)
dp[0] = 1
for i in a:
    j = m
    while j>=i:
        dp[j] += dp[j-i]
        j -= 1
print(dp[m])
