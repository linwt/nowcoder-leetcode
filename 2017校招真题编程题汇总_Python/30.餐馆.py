import bisect
n, m = map(int, raw_input().split())
a = map(int, raw_input().split())
p = [map(int, raw_input().split()) for _ in range(m)]
a.sort()
# 按消费高到低排序
p.sort(key=lambda x: x[1], reverse=True)
count = 0
# 遍历客人
for i in range(len(p)):
    # 二分法查找，返回该数值将会插入的位置但不会插入，即得到≥该数的索引
    j = bisect.bisect_left(a, p[i][0])
    if j>=len(a):
        continue
    count += p[i][1]
    del a[j]
print(count)