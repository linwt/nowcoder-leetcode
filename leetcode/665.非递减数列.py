class Solution(object):
    def checkPossibility(self, nums):
        if len(nums) < 3:
            return True
        count = 0
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                count += 1
                if count > 1:
                    return False
                # 发现不满足条件的值要先改动，后面再继续判断
                # 2 4 2(i) 6    改i-1可使后面尽可能满足递增
                if i-2 < 0 or nums[i-2] <= nums[i]:
                    nums[i-1] = nums[i]
                # 3 4 2(i) 6    i-1不能改，只能改当前值
                else:
                    nums[i] = nums[i-1]
        return True