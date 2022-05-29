# 进制转换方法：除基取余，余数逆置
a = map(int, raw_input().split())
m, n = a[0], a[1]
s = '0123456789ABCDEF'
res = ''
flag = 0
if m<0:
    m = -m
    flag = 1
while m:
    res += s[m%n]
    m /= n
if flag:
    res += '-'
    print(res[::-1])
else:
    print(res[::-1])