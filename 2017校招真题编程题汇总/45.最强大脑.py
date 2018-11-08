# 将序列的正反方向进行判断
s, s1, s2 = raw_input(), raw_input(), raw_input()
f = b = False
for i,s in enumerate([s, s[::-1]]):
    if (s1 in s) and (s2 in s[s.index(s1)+len(s1):]):
        if i == 0:
            f = True
        if i == 1:
            b = True
if f:
    if b:
        print('both')
    else:
        print('forward')
elif b:
    print('backward')
else:
    print('invalid')