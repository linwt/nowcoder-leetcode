# 1,2,3,7求和结果为13，则可组成的数为1-13
n = int(raw_input())
a = map(int, raw_input().split())
a.sort()
res = 0
for i in a:
    # 相减大于1说明有空档
    if i-res>1:
        break
    res += i
print(res+1)