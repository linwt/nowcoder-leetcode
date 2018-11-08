# 类似49题
# 将字符串拼接类比环

# 寻找每个包含'ABCDE'的区间，最终排序得出最小的区间
s = raw_input()
s2 = s+s
res = []
i, j = 0, 5
while j<len(s2) and i<len(s):
    if 'A' in s2[i:j] and 'B' in s2[i:j] and 'C' in s2[i:j] and 'D' in s2[i:j] and 'E' in s2[i:j]:
        res.append(j-i)
        i += 1
    else:
        j += 1
print(len(s)-min(res))