# 递归
n, m = map(int, raw_input().split())
res = []
def getResult(n, m, res, begin):
    if m==0:
        print(' '.join(res))
    for i in range(begin, n+1):
        res.append(str(i))
        getResult(n, m-i, res, i+1)
        res.pop()
getResult(n, m, res, 1)