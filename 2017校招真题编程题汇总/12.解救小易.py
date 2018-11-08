# 起点到陷阱的最短距离为x+y-2
num = int(raw_input())
x = [int(i) for i in raw_input().split()]
y = [int(i) for i in raw_input().split()]
a = []
for j in range(num):
    a.append(x[j]+y[j]-2)
print(min(a))