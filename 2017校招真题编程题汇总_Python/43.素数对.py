import math
n = int(raw_input())
s = []
for i in range(2, n):
    flag = 1
    # 判断是否为质数
    for j in range(2, int(math.sqrt(i))+1):
        if i%j==0:
            flag = 0
            break
    if flag:
        s.append(i)
count = 0
# 判断质数的和是否等于输入的数
for i,v in enumerate(s):
    if n-v in s[i:]:
        count += 1
print(count)