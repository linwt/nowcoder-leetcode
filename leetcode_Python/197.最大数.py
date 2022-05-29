class Solution(object):
    def largestNumber(self, nums):
        nums = map(str, nums)
        # 两两相加比较，大于则交换位置
        nums.sort(cmp = lambda x, y: cmp(y+x, x+y))
        # 结果需要先去除最左边的0
        return ''.join(nums).lstrip('0') if ''.join(nums).lstrip('0') else '0'