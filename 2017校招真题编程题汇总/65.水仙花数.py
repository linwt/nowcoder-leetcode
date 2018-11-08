# 取出数的每一位，按要求计算
l = list(map(int, raw_input().split()))
m, n = l[0], l[1]
res = []
for i in range(m, n+1):
    a = i%10
    b = i/10%10
    c = i/100
    if i == a**3+b**3+c**3:
        res.append(i)
if not res:
    print('no')
else:
    print(' '.join(map(str, res)))