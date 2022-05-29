# 方法一：直接平方根
class Solution(object):
    def isPerfectSquare(self, num):
        return (num**0.5) == int(num**0.5)

# 方法二：二分法，查找是否存在一个数的平方为给定的正整数
class Solution(object):
    def isPerfectSquare(self, num):
        l, r = 0, num
        while l <= r:
            mid = (l+r)/2
            square = mid**2
            if square > num:
                r = mid - 1
            elif square < num:
                l = mid + 1
            else:
                return True
        return False