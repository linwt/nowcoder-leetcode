# 使用右移运算符，逐位跟1进行'与'运算
class Solution:
    def NumberOf1(self, n):
        return sum([(n>>i & 1) for i in range(32)])