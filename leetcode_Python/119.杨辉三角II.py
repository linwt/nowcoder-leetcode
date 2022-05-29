class Solution(object):
    def getRow(self, rowIndex):
        for k in range(rowIndex+1):
            cur = [1]*(k+1)
            if k >= 2:
                for i in range(1, k):
                    cur[i] = pre[i] + pre[i-1]
            pre = cur
        return cur