n = int(raw_input())
count = 0
# 遍历每个数
for i in range(1, n+1):
    s1 = s2 = 0
    # 数的每一位累加
    for j in str(i):
        s1 += int(j)
    # 二进制位累加
    while i:
        s2 += (i%2)
        i /= 2
    if s1 == s2:
        count += 1
print(count)