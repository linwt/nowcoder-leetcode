class Solution(object):
    def repeatedStringMatch(self, A, B):
        count = 1
        S = A
        while len(S) < len(B):
            S += A
            count += 1
        # 判断第一次叠加后长度大于B是否包含
        if B in S:
            return count
        # 判断第二次，如果不包含则不存在
        if B in S+A:
            return count+1
        return -1