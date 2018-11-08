# 冒泡排序
n = int(raw_input())
m = list(raw_input().split())
for i in range(n-1):
    for j in range(n-1-i):
        if m[j]+m[j+1] < m[j+1]+m[j]:
            m[j], m[j+1] = m[j+1], m[j]
print(''.join(m))

# sort()方法排序
n = int(raw_input())
m = raw_input().split()
# 默认由小到大排序，反转则由大到小排序
m.sort(cmp=lambda x,y: cmp(x+y, y+x), reverse=True)
print(''.join(m))