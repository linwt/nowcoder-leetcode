# 与中间数比较即可
n = int(raw_input())
left = -90
right = 90
res = ''
while right-left>3:
    mid = int((left+right)/2.0)
    if n >= mid:
        res += '1'
        left = mid
    else:
        res += '0'
        right = mid
print(res)