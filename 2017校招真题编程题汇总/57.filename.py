# 文件扩展名以'.'开始
s = raw_input()
if '.' not in s:
    print('null')
else:
    print(s[(s.index('.')+1):])