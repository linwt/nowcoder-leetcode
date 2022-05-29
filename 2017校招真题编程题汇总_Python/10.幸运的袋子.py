# 递归
n = int(raw_input())
x = map(int, raw_input().split())
x.sort()
def lucky(x, lsum, lmul):
    res = 0
    for i in range(len(x)):
        if i>0 and x[i]==x[i-1]:
            continue
        lsum += x[i]
        lmul *= x[i]
        if lsum > lmul:
            # 符合条件则继续往下扩展一位
            res = res+1+lucky(x[i+1:], lsum, lmul)
        elif x[i] == 1:
            res = res+lucky(x[i+1:], lsum, lmul)
        else:
            break
        # 回溯一位，继续扩展
        lsum -= x[i]
        lmul /= x[i]
    return res
print(lucky(x, 0, 1))