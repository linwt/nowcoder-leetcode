class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        # 两个矩形的面积
        a = (C-A) * (D-B)
        b = (G-E) * (H-F)
        # 重叠部分的面积
        x = max(0, min(C, G) - max(A, E))
        y = max(0, min(D, H) - max(B, F))
        area = a+b-x*y
        return area