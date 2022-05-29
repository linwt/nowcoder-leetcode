# 根据返回结果重新定位左右区间
class Solution(object):
    def guessNumber(self, n):
        l, r = 1, n
        while l <= r:
            mid = (l+r)/2
            if guess(mid) == -1:
                r = mid - 1
            elif guess(mid) == 1:
                l = mid + 1
            else:
                return mid