# 若有重叠，则横坐标上，矩形2的左下角小于矩形1的右上角，矩形2的右上角大于矩形1的左小角，纵坐标同理
class Solution(object):
    def isRectangleOverlap(self, rec1, rec2):
        x1, y1, x2, y2 = rec1
        x3, y3, x4, y4 = rec2
        return (x3-x2)*(x4-x1)<0 and (y3-y2)*(y4-y1)<0