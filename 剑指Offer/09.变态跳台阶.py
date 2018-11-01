# f(1)=1  f(2)=2  f(3)=4  f(4)=8
# f(n)=2的n-1次方
class Solution:
    def jumpFloorII(self, number):
        if number <= 0:
            return 0
        return pow(2, number-1)