# 1、数字位求和  2、最大公约数
n = int(raw_input())
s = 0
for i in range(2, n):
    t = n
    while t:
        s += (t%i)
        t /= i
f = s
r = m = n-2
# r：余数 f:公约数
while r:
    f, r = r, f%r
s /= f
m /= f
print('%d/%d'%(s,m))