class Solution(object):
    def buddyStrings(self, A, B):
        # 长度不相等
        if len(A) != len(B):
            return False
        # 找出不相等的字符
        res = []
        for i in range(len(A)):
            if A[i] != B[i]:
                res.append(A[i]+B[i])
        # 刚好两个位置不相等
        if len(res) == 2:
            return res[0][::-1] == res[1]
        # 全部相等，则找出A是否含有两个相等的字符交换
        if len(res) == 0:
            return any(i>1 for i in collections.Counter(A).values())
        # 其他情况
        return False