# 理解规律，后一天价格减前一天价格大于0，则累加利润
class Solution(object):
    def maxProfit(self, prices):
        pro = 0
        for day in range(len(prices)-1):
            differ = prices[day+1] - prices[day]
            if differ > 0:
                pro += differ
        return pro