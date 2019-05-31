# 暴力破解
class Solution(object):
    def readBinaryWatch(self, num):
        res = []
        for i in range(12):
            for j in range(60):
                if bin(i).count('1') + bin(j).count('1') == num:
                    s = str(i) + ':' + ('0'+str(j) if j<10 else str(j))
                    res.append(s)
        return res