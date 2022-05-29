import math
n, m = map(int, raw_input().split())
s = 0
for i in range(m):
    s += n
    n = math.sqrt(n)
print('%.2f'%s)