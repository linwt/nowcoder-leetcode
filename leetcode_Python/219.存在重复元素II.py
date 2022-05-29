# 使用字典，如果元素不在字典中，则更新字典。若在字典中，则计算索引距离，若距离≤k则为True，否则更新字典
class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        d = {}
        for i, num in enumerate(nums):
            if num not in d:
                d[num] = i
            else:
                if i-d[num] <= k:
                    return True
                d[num] = i
        return False