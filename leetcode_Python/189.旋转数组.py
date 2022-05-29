# 方法一：每一次旋转将最后一个元素放到首位
class Solution(object):
    def rotate(self, nums, k):
        for _ in range(k):
            num = nums.pop()
            nums.insert(0, num)

# 方法二：数组局部交换位置
class Solution(object):
    def rotate(self, nums, k):
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]