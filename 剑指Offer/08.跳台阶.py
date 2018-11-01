# 思路：f(1)=1  f(2)=2  f(3)=3  f(4)=5  f(5)=8
# 将具体的事物抽象成数学规律。类似斐波那契数列

# 方法一：递推
class Solution:
    def jumpFloor(self, number):
        a, b = 1, 1
        for i in range(number):
            a, b = b, a+b
        return a

# 方法二：递归
class Solution:
    def jumpFloor(self, number):
        a = [0, 1, 2]
        if number in a:
            return a[number]
        return self.jumpFloor(number-1) + self.jumpFloor(number-2)