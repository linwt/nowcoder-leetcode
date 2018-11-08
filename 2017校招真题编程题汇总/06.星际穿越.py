# 解方程 x*x+x<=h
# 方法一
import math
h = int(raw_input())
x = int(math.sqrt(h))
if h-x*x>=x:
    print(x)
else:
    print(x-1)

# 方法二
print(int(((1+4*input())**0.5-1)/2))