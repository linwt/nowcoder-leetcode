# 前缀和解法，类似公交站记录上车人数和下车人数，每一站的人数为上一站的人数加上当前站的变化人数
class Solution(object):
    def corpFlightBookings(self, bookings, n):
        res = [0]*n
        for b in bookings:
            l, r = b[0]-1, b[1]
            res[l] += b[2]
            if r < n:
                res[r] -= b[2]
        for i in range(1, n):
            res[i] += res[i-1]
        return res