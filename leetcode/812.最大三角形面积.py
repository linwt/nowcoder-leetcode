# 三角形面积公式 S=(1/2)*(x1y2+x2y3+x3y1-x1y3-x2y1-x3y2)
class Solution(object):
    def largestTriangleArea(self, points):
        res = 0
        for x in points:
            for y in points:
                for z in points:
                    res = max(res, 0.5*(x[0]*y[1] + y[0]*z[1] + z[0]*x[1]- x[0]*z[1] - y[0]*x[1] - z[0]*y[1]));
        return res