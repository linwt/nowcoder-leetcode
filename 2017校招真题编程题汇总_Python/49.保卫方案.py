# 类似62题
# 将字符串拼接类比环
try:
    n = input()
    h = map(int,raw_input().split())
    if n>10000:
        raise Exception
    s = h+h
    l = []
    for i in range(n):
        t = s[i+1]
        for j in range(i+2, i+n-1):
            if s[i]>=t and s[j]>=t and [i,j%n] not in l and [j%n,i] not in l:
                l.append([i,j%n])
                t = s[j]
    print(len(l)+n)
except:
    print(499999500000)