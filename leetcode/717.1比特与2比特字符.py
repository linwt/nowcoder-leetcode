# 由于1必须组合，则遇1走两步，遇0走一步，到最后若剩一个字符则为True
class Solution(object):
    def isOneBitCharacter(self, bits):
        i = 0
        while i < len(bits):
            if i == len(bits)-1:
                return True
            if bits[i] == 1:
                i += 2
            else:
                i += 1
        return False