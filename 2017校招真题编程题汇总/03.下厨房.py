# 每个字符串加到集合中去重
import sys
s = set()
for line in sys.stdin:
    for i in line.split():
        s.add(i)
print(len(s))