# f(1)=3  f(2)=9  f(3)=21
# f(n)= 2*f(n-1)+f(n-2)

# 递归写法
def cal(n):
    if n==1:
        return 3
    if n==2:
        return 9
    return 2*cal(n-1) + cal(n-2)
n = int(raw_input())
print(cal(n))

# 递推写法
n = int(raw_input())
a, b = 3, 9
if n==1:
    print(a)
elif n==2:
    print(b)
else:
    for _ in range(n-2):
        a, b = b, 2*b+a
    print(b)

# 数组追加写法
n = int(raw_input())
res = [3,9]
for i in range(2, n):
    res.append(2*res[i-1] + res[i-2])
print(res[n-1])