# 使用三指针，当命中下一个丑数时，说明该指针指向的丑数乘以对应权重所得积最小，此时该指针应该指向下一个丑数
# 使用三个并列的if让符合条件的指针都指向一个更大的数
class Solution(object):
    def nthUglyNumber(self, n):
        res = [1]
        idx2 = idx3 = idx5 = 0
        for i in range(n-1):
            res.append(min(res[idx2]*2, res[idx3]*3, res[idx5]*5))
            if res[-1] == res[idx2]*2:
                idx2 += 1
            if res[-1] == res[idx3]*3:
                idx3 += 1
            if res[-1] == res[idx5]*5:
                idx5 += 1
        return res[-1]