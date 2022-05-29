# rev(rev(x) + rev(y)) 利用字符串的反转功能实现即可
x, y = raw_input().split()
x, y = int(x[::-1]), int(y[::-1])
print(int(str(x+y)[::-1]))