# 双指针移动
class Solution(object):
    def maxArea(self, height):
        l, r, m = 0, len(height)-1, 0
        while l < r:
            # 记录当前最大面积
            hl, hr = height[l], height[r]
            cur = min(hl, hr) * (r-l)
            m = max(m, cur)
            # 高度较小一端向内移动，获得可能更大的面积
            if hl < hr:
                l += 1
            else:
                r -= 1
        return m