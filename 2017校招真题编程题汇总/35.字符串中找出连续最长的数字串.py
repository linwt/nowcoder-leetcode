# 方法一：正则匹配
import re
s = raw_input()
str_list = re.findall(r'\d+', s)
print(max(str_list, key=len))

# 方法二：遍历字符串，记录长度与字符串
s = raw_input()
cur_len = max_len = 0
cur_str = max_str = ''
for i,v in enumerate(s):
    if v>='0' and v<='9':
        cur_len += 1
        cur_str += v
        if cur_len > max_len:
            max_len = cur_len
            max_str = cur_str
    else:
        cur_len = 0
        cur_str = ''
print(max_str)