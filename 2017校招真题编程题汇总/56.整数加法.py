# 非数字字符转化为整数会抛异常
a, b = raw_input().split()
try:
    print(int(a)+int(b))
except:
    print('error')