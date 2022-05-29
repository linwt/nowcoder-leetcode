# 将A数组解压，遍历解压列表，若元组非降序排列，则需要删除一个索引
class Solution(object):
    def minDeletionSize(self, A):
        res = 0
        for i in zip(*A):
            if list(i) != sorted(i):
                res += 1
        return res