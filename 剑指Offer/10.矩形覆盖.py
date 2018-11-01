# 类似斐波那契数列：f(1)=1  f(2)=2  f(3)=3  f(4)=5
class Solution:
    def rectCover(self, number):
        if number == 0:
            return 0
        a, b = 0, 1
        for i in range(number):
            a, b = b, a+b
        return b