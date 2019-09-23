# 逆向求解，对Y进行除、加逐步逼近X
class Solution(object):
    def brokenCalc(self, X, Y):
        if X > Y:
            return X - Y
        res = 0
        while X < Y:
            # Y为奇数时除后非整所以只能加
            if Y % 2:
                Y += 1
            # Y为偶数时就除，逼近X
            else:
                Y /= 2
            res += 1
        # Y比X小后逐步加直到等于X
        return X - Y + res