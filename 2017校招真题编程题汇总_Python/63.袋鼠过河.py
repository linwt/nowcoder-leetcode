# 动态规划

# 写法一
n = int(raw_input())
steps = map(int, raw_input().split())
count = [1]*n
left = 0
for i in range(n):
    step = steps[i]
    if step == 0 and left == i:
        print(-1)
        break
    if i+step > left:
        if i+step >= n:
            print(count[i])
            break
        for j in range(left+1, step+i+1):
            count[j] = count[i] + 1
        left = step + i

# 写法二
inf = float('inf')
a, b = int(raw_input()), list(map(int,raw_input().split()))
dp = [inf]*10000
dp[0] = 0
for i in range(1,a+1):
    for j in range(i):
        if b[j]+j >= i:
            dp[i] = min(dp[i], dp[j]+1)
print(-1 if dp[a]==inf else dp[a])