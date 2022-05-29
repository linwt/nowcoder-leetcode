# 暴力破解。超过限制的内存
n, m = map(int, raw_input().split())
s = [str(i) for i in range(1, n+1)]
s.sort()
print(s[m-1])

# 将字典序视作一个树，寻找m次则循环m次来找寻结果
# 如果在这个区间内则M在这个区间内查找，让i+1一个一个查找，否则让梯度乘以10向上查找
# 第一个while循环是判断是否查到这个位置，第二个则是写出num在这个区间内有多少个数
n, m = map(int, raw_input().split())
result = 1
m -= 1
while m:
    count = 0
    start = result
    end = result + 1
    while start <= n:
        count += min(end, n+1) - start
        start *= 10
        end *= 10
    if count > m:
        result *= 10
        m -= 1
    else:
        result += 1
        m -= count
print(result)