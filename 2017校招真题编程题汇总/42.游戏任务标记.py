# 判断条件即可
a, b = map(int, raw_input().split())
if (a>=1 and a<=1024) and (b>=1 and b<=1024):
    if a==b:
        print(1)
    else:
        print(0)
else:
    print(-1)