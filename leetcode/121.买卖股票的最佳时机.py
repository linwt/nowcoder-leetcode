# 遍历列表，记录价格最小值，保存最大差值
class Solution(object):
    def maxProfit(self, prices):
        min_p, max_p = 99999, 0
        for i in prices:
            min_p = min(min_p, i)
            max_p = max(max_p, i-min_p)
        return max_p