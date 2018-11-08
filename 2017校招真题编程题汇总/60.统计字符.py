# 使用字典存放并累加字符个数
s = raw_input()
d = {}
for i in s:
    if i in d:
        d[i] += 1
    else:
        d[i] = 1
    if d[i] == 3 and i.isalpha():
        print(i)
        break