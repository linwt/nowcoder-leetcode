# 方法一：i遍历起点，j遍历起点后的序列
class Solution:
    def FindContinuousSequence(self, tsum):
        if tsum < 3:
            return []
        l = []
        end = (tsum+1)/2
        for i in range(1, end):
            nsum = i
            for j in range(i+1, end+1):
                nsum += j
                if nsum == tsum:
                    l.append(range(i, j+1))
                if nsum > tsum:
                    break
        return l

# 方法二：窗口滑动
class Solution:
    def FindContinuousSequence(self, tsum):
        if tsum < 3:
            return []
        res = []
        start = 1
        end = 2
        s = start + end
        while start < (tsum+1)/2:
            if s < tsum:
                end += 1
                s += end
            elif s == tsum:
                res.append(range(start, end+1))
                s -= start
                start += 1
            else:
                s -= start
                start += 1
        return res