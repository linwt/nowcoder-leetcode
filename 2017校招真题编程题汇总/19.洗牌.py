# 一轮洗牌：1,2,3,4,5,6 --> 1,4,2,5,3,6
t = int(raw_input())
n, k = map(int, raw_input().split())
for _ in range(t):
    data = raw_input().split()
    num = data[:2*n]
    res = ['']*(2*n)
    for _ in range(k):
        # 插空排放
        res[::2] = num[:n]
        res[1::2] = num[n:]
        num = res[:]
    n, k = int(data[-2]), int(data[-1])
    print(' '.join(res))