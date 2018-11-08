# 插入后反转字符串，若与原来相等则是回文串
a = list(raw_input())
b = raw_input()
c = a[:]
count = 0
for i in range(len(c)+1):
    a.insert(i, b)
    s = ''.join(a)
    if s[:]==s[::-1]:
        count += 1
    a = c[:]
print(count)