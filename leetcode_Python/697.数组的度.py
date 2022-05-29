# 统计每个元素的个数存放到字典中，将最大频数元素出现的首尾索引保存，找到其中的最小距离
class Solution(object):
    def findShortestSubArray(self, nums):
        d = collections.Counter(nums)
        left, right = {}, {}
        for i, v in enumerate(nums):
            # left.setdefault(v, i)
            if v not in left:
                left[v] = i
            right[v] = i
        max_v = max(d.values())
        return min(right[k]-left[k]+1 for k in d if d[k]==max_v)