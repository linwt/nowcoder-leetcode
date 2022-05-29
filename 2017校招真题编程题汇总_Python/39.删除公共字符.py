# 在新字符串中追加需要的字符
s1 = raw_input()
s2 = raw_input()
s = ''
for i in s1:
    if i not in s2:
        s += i
print(s)