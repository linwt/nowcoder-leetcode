# 先分别求两数组的和，再求总和之差的一半，得到两数组分别需要增减的值。再遍历数组，得到符合增减条件的两个数
class Solution(object):
    def fairCandySwap(self, A, B):
        sumA, sumB, setB = sum(A), sum(B), set(B)
        for a in A:
            b = (sumB-sumA)/2 + a
            if b in setB:
                return [a, b]