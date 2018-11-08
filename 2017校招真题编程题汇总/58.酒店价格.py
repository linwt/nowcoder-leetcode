# 用一个数组存放每个日期的价格，然后遍历数组，价格不同时则分段
import sys
min_, max_ = 100000, 0
values = [0]*100000
for line in sys.stdin.readlines():
    l, r, v = map(int, line.split())
    if l < min_:
        min_ = l
    if r > max_:
        max_ = r
    for i in range(l, r+1):
        values[i] = v
res = '[' + str(min_) + ', '
for i in range(min_+1, max_+1):
    if values[i] != values[i-1]:
        if values[i-1] != 0:
            res += str(i-1) + ', ' + str(values[i-1]) + '],'
        if i < max_ and values[i] != 0:
            res += '[' + str(i) + ', '
res += str(max_) + ', ' + str(values[max_]) + ']'
print(res)