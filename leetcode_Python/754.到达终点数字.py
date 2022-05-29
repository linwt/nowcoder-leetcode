# 左右都一样，target取绝对值方便计算。
# 从0往前一直累加，若总和刚好等于target，则返回当前步数。
# 若总和大于target并且两者之差为偶数2n，则在第n步往左走同样可刚好到达target，因为左走n步，sum就减少2n步。
class Solution(object):
    def reachNumber(self, target):
        step = sum = 0
        target = abs(target)
        while 1:
            step += 1
            sum += step
            if sum == target or (sum > target and (sum-target)%2 == 0):
                return step