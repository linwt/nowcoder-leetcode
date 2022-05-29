N,M=map(int,raw_input().split())
divs = [[] for i in range(M+1)]
#i 表示公约数 公因子 以2开始算
for i in range(2, M+1):
    for j in range(i+i, M+1, i):
        #j表示以i为约数的所有数，即都有公共约数i 通过这两个嵌套循环，实现了每个位置j上都有对应的一组约数
        divs[j].append(i)
res = [0]*(M+1)
#表示步数，初始化为1，到最后面减1
res[N] = 1
for n in range(N, M):
    if res[n]:
        for dn in divs[n]:
            if n + dn <= M:
                res[n+dn] = min(res[n+dn], res[n] + 1) if res[n+dn] else res[n] + 1
print(res[M]-1 if res[M] else -1)