# 502104 19880330 8324 按照此格式划分
s = raw_input()
if len(s)<6:
    print(s)
elif len(s)<14:
    print(s[:6] + ' ' + s[6:])
else:
    print(s[:6] + ' ' + s[6:14] + ' ' + s[14:])