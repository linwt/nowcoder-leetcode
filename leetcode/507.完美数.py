# 方法一：将正因子相加判断是否等于给定的正整数
class Solution(object):
    def checkPerfectNumber(self, num):
        if num <= 1:
            return False
        sum = 1
        for i in range(2, int(math.sqrt(num))+1):
            if num%i == 0:
                sum += (i + num/i)
        return num == sum

# 方法二：1e8以内只有5个完美数
class Solution(object):
    def checkPerfectNumber(self, num):
        return num in [6,28,496,8128,33550336]