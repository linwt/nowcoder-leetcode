# 先按表达式求出ABC的值，再做逆运算验证是否正确
n = [int(i) for i in raw_input().split()]
A = (n[0]+n[2])/2
B = (n[1]+n[3])/2
C = B - n[1]
if A-B==n[0]:
    print(A,B,C)
else:
    print('No')