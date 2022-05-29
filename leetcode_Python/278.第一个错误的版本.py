# 二分法，取中间版本进行判断，若是好版本则将左起始点设为中间版本之后，若是坏版本则将右起始点设为为中间版本
class Solution(object):
    def firstBadVersion(self, n):
        l, r = 1, n
        while l < r:
            mid = (l+r)/2
            if isBadVersion(mid):
                r = mid
            else:
                l = mid + 1
        return l
