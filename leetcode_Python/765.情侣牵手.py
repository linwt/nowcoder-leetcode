# 贪心。遍历偶数位置，若下一位置不是匹配的情侣，则将下一位置与情侣交换位置
class Solution(object):
    def minSwapsCouples(self, row):
        res = 0
        for i in range(0, len(row), 2):
            if row[i] % 2 == 0:
                if row[i+1] != row[i]+1:
                    res += 1
                    j = row.index(row[i]+1)
                    row[i+1], row[j] = row[j], row[i+1]
            else:
                if row[i+1] != row[i]-1:
                    res += 1
                    j = row.index(row[i]-1)
                    row[i+1], row[j] = row[j], row[i+1]
        return res