# 按题目说明解法
class Solution(object):
    def lastRemaining(self, n):
        nums = [i+1 for i in range(n)]
        res = []
        while len(nums) > 1:
            for i in range(1, len(nums), 2):
                res.append(nums[i])
            nums, res = res[::-1], []
        return nums[0]


# 找规律，如果输入a输出b，则输入2a输出2*（a-b+1）
class Solution(object):
    def lastRemaining(self, n):
        if n == 1:
            return 1
        return 2 * (n/2 - self.lastRemaining(n/2) + 1)