# 只要给对手留下4的整数倍个石子就能赢，否则就输
class Solution(object):
    def canWinNim(self, n):
        return n%4 != 0