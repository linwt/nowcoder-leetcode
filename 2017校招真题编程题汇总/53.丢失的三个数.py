# 求差集
n1 = map(int, raw_input().split())
n2 = [i for i in range(1, 10001)]
n3 = sorted(list(map(str, set(n2).difference(set(n1)))))
res = int(''.join(n3))%7
print(res)