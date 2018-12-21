# 分到的糖果个数和糖果的种类数取较小者
class Solution(object):
    def distributeCandies(self, candies):
        return min(len(candies)/2, len(set(candies)))