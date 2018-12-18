# 左右两边0的个数即为最大距离，中间0的个数的一半即为最大距离，再比较出最大
class Solution(object):
    def maxDistToClosest(self, seats):
        pre, res = -1, 1
        for i in range(len(seats)):
            if seats[i]:
                # 左边
                if pre < 0:
                    res = i
                # 中间
                else:
                    res = max(res, (i-pre)/2)
                pre = i
        # 右边
        return max(res, len(seats)-1-pre)