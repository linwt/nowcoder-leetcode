import math
n = int(raw_input())
i = count = 0
while i**2 <= n/2.0:
    j_square = n-i**2
    j = int(math.sqrt(j_square))
    # 验证该数是否为整数
    if j**2==j_square:
        if i==0 or i==j:
            count += 4
        else:
            count += 8
    i += 1
print(count)