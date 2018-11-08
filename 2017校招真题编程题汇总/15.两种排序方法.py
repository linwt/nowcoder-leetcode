# 字符串序列或字符串对应的长度序列调用sort()方法后，若与原序列相同，则已经排好序了
n = int(raw_input())
str1 = []
len1 = []
for i in range(n):
    str1.append(raw_input())
    len1.append(len(str1[i]))
str2, len2 = str1[:], len1[:]
str2.sort()
len2.sort()
if len1 == len2:
    if str1 == str2:
        print('both')
    else:
        print('lengths')
elif str1 == str2:
    print('lexicographically')
else:
    print('none')