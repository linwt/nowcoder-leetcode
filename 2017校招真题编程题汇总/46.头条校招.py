# 案例：
# 2,14,15,30,42,100
# 2,14,15,30,100,100

n = int(raw_input())
d = map(int, raw_input().split())
# 添加两个数防止循环过程数组下标越界，也要防止干扰原始数据
d += [121, 121]
d.sort()
i = count = 0
while i<n:
    j = 1
    if d[i]+10>=d[i+1]:
        if d[i]+20>=d[i+2]:
            j += 2
        else:
            j += 1
    count += (3-j)
    i += j
print(count)