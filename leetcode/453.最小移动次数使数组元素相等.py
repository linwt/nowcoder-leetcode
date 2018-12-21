# 方法一：每次移动可以使n-1个元素增加1，即使最大元素减1，循环达到所有元素值都为最小元素值
class Solution(object):
    def minMoves(self, nums):
        min_v = min(nums)
        count = 0
        for num in nums:
            count += num-min_v
        return count

# 方法二：即方法一同样思路另一种写法
class Solution(object):
    def minMoves(self, nums):
        return sum(nums) - min(nums) * len(nums)