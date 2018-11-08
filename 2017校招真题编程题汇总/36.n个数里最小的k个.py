# 写法一：字符串追加
a = [int(i) for i in raw_input().split()]
k, n = a[-1], a[:-1]
n.sort()
res = ''
for i in range(k-1):
    res += str(n[i])+' '
res += str(n[i+1])
print(res)

# 写法二：取字符串一段区间
a = list(map(int, raw_input().split()))
k, n = a[-1], a[:-1]
print(' '.join(list(map(str, sorted(n)[:k]))))