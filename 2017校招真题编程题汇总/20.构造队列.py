# 逆推
# 原操作：1、将队首元素放到队尾  2、将新队首元素输出
# 逆操作：1、将输出元素插入到队首  2、将队尾元素插入到队首
t = int(raw_input())
for _ in range(t):
    n = int(raw_input())
    res = []
    for i in range(n, 0, -1):
        res.insert(0, i)
        res.insert(0, res.pop())
    print(' '.join(map(str, res)))