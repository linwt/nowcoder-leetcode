class Solution(object):
    def advantageCount(self, A, B):
        n = len(B)
        A.sort()
        # 记录元素的值和索引
        B = [(B[i], i) for i in range(n)]
        B.sort()
        # 使用左右指针指向B的左右两端
        l, r, k, res = 0, n-1, 0, [0]*n
        for a in A:
            # A的元素大于B的元素，则将A的元素放到B的元素对应的索引位置上
            if a > B[l][0]:
                res[B[l][1]] = a
                l += 1
            # 否则放到B最后一个元素对应的索引位置上
            else:
                res[B[r][1]] = a
                r -= 1
        return res