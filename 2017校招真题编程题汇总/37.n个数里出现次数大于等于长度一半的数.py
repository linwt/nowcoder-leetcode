# 利用列表的count()方法
n = list(raw_input().split())
m = set(n)
for i in m:
    if n.count(i) >= len(n)/2:
        print(i)
        break