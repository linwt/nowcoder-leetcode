# 从长宽差距最小处开始判断，符合条件则返回
class Solution(object):
    def constructRectangle(self, area):
        for i in range(int(math.sqrt(area)), 0, -1):
            if area%i == 0:
                return [area/i, i]