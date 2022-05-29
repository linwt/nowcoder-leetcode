# 方法一：先算阶乘结果，再求0。算法复杂度太高
n = int(raw_input())
res = 1
for i in range(1,n+1):
    res *= i
count = 0
while res%10==0:
    count += 1
print(count)

# 方法二：0由偶数乘5得到，输入的整数的阶乘序列有几个5的倍数就有几个0
n = int(raw_input())
count = 0
while n:
    count += (n/5)
    n /= 5
print(count)
