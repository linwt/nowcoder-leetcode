import itertools
n, k = map(int, raw_input().split())
A = map(int, raw_input().split())
miss_num = []
miss_index = []
res = 0
# 计算序列顺序对个数
def findCount():
    count = 0
    for i in range(len(A)-1):
        j = i+1
        while j<len(A):
            if A[i]<A[j]:
                count += 1
            j += 1
    return count
# 找出缺失数
for i in range(1,n+1):
    if i not in A:
        miss_num.append(i)
# 找出缺失数的索引
for i,v in enumerate(A):
    if v == 0:
        miss_index.append(i)
# 将缺失数进行排列组合
items = itertools.permutations(miss_num,len(miss_num))
for item in items:
    for i,v in enumerate(item):
        A[miss_index[i]] = v
    if findCount() == k:
        res += 1
print(res)