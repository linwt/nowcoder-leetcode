# 从0开始遍历判断，如果非负整数c减去一个数的平方后，计算其平方根，结果为整数说明存在
class Solution(object):
    def judgeSquareSum(self, c):
        a = 0
        while a**2 <= c:
            if int(math.sqrt(c - a**2)) == math.sqrt(c - a**2):
                return True
            a += 1
        return False