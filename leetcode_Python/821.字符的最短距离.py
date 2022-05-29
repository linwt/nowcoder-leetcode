class Solution(object):
    def shortestToChar(self, S, C):
        res = []
        for i in range(len(S)):
            # 分别从当前索引的左边和右边找第一个C字符
            left, right = S[i::-1].find(C), S[i:].find(C)
            # -1表示没有
            if left == -1:
                left = 10000
            if right == -1:
                right = 10000
            res.append(min(left , right))
        return res