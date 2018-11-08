# 暴力破解。超过限制的内存
from itertools import combinations
n, m = map(int, raw_input().split())
A = map(int, raw_input().split())
nums = list(combinations(A, 2))
count = 0
for num in nums:
    x, y = num[0], num[1]
    if x^y > m:
        count += 1
print(count)

# 调用函数写法
from itertools import combinations
n, m = map(int, raw_input().split())
print(len(list(filter(lambda x: x>m, map(lambda x:x[0]^x[1], combinations(list(map(int, raw_input().split())), 2))))))
