# 连接，去重，排序
n, m = raw_input().split()
a = map(int, raw_input().split())
b = map(int, raw_input().split())
c = map(str, sorted(list(set(a+b))))
print(' '.join(c))