# 若数组i位置加上可跳跃步数大于终点位置，且i位置可到达，则能够到达终点
class Solution(object):
    def canJump(self, nums):
        max_step = 0
        for i in range(len(nums)):
            if i > max_step:
                return False
            max_step = max(nums[i]+i, max_step)
        return True