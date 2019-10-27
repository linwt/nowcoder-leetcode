# 如果最终能整排值相同，那么两排各自的第一个多米诺骨牌至少有一个是目标值
# 取两排第一个值分别进行判断，检查其他多米诺骨牌是否出现该值，若都出现则求出最小翻转次数
class Solution(object):
    def minDominoRotations(self, A, B):
        def check(x, n):
            a, b = 0, 0
            for i in range(n):
                if A[i] != x and B[i] != x:
                    return -1
                elif A[i] != x:
                    a += 1
                elif B[i] != x:
                    b += 1
            return min(a, b)

        n = len(A)
        res = check(A[0], n)
        if res != -1:
            return res
        else:
            return check(B[0], n)