# 方法一：索引递增
s, t = raw_input(), raw_input()
j = flag = 0
for i in s:
    if i == t[j]:
        j += 1
    if j == len(t):
        flag = 1
        break
print('Yes' if flag else 'No')

# 方法二：字符串截取
s, t = raw_input(), raw_input()
for i in s:
    if t and i == t[0]:
        t = t[1:]
print('No' if t else 'Yes')