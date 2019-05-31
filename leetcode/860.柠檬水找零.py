# 三种情况分别讨论
class Solution(object):
    def lemonadeChange(self, bills):
        d = {5:0, 10:0, 20:0}
        for b in bills:
            if b == 5:
                d[5] += 1
            elif b == 10:
                if d[5] < 1:
                    return False
                d[5] -= 1
                d[10] += 1
            else:
                if d[5] > 0 and d[10] > 0:
                    d[5] -= 1
                    d[10] -= 1
                    d[20] += 1
                elif d[5] > 2:
                    d[5] -= 3
                    d[20] += 1
                else:
                    return False
        return True