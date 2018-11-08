# ＊＊    ＊＊   ＊＊
# ＊＊    ＊＊   ＊＊
#     ＊＊   ＊＊   ＊＊
#     ＊＊   ＊＊   ＊＊
# ＊＊    ＊＊   ＊＊
# ＊＊    ＊＊   ＊＊
# 由数据规律分三种情况讨论
n, m = map(int, raw_input().split())
if n%4==0 or m%4==0:
    print(n*m/2)
elif n%2==0 and m%2==0:
    print((n*m/4+1)*2)
else:
    print(n*m/2+1)