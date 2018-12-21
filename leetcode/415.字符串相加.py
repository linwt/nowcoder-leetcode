# eval()执行字符串表达式
class Solution(object):
    def addStrings(self, num1, num2):
        return str(eval(num1) + eval(num2))