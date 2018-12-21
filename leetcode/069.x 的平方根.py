# 方法一：数学函数
class Solution(object):
    def mySqrt(self, x):
        return int(math.sqrt(x))

# 方法二：1/2次方取整
class Solution(object):
    def mySqrt(self, x):
        return int(x**(1/2.0))