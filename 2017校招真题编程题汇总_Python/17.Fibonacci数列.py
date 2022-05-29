# 递推找到离整数最近的左右两个Fibonacci数，求差取最小即为最少步数
a, b = 0, 1
n = int(raw_input())
while n>b:
    a, b = b, a+b
print(min(n-a, b-n))