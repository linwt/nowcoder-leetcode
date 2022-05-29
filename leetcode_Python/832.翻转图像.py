# 将逆序后的数组映射到自定义函数，元素为1则减1，元素为0则加1
class Solution(object):
    def flipAndInvertImage(self, A):
        res = []
        for a in A:
            res.append(list(map(lambda x: x-1 if x else x+1, a[::-1])))
        return res