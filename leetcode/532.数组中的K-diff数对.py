class Solution(object):
    def findPairs(self, nums, k):
        if k < 0:
            return 0
        # 使用字典保存元素和个数
        d = collections.Counter(nums)
        res = 0
        for num in d:
            if num + k in d:
                # 当k为0时该元素至少需要出现两次
                if (k == 0 and d[num] >= 2) or k != 0:
                    res += 1
        return res