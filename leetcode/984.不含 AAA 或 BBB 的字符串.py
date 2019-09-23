class Solution(object):
    def strWithout3a3b(self, A, B):
        # 使A大于B
        a, b = 'a', 'b'
        if A < B:
            a, b = b, a
            A, B = B, A

        res = ''
        # A的数量多于B时构造 'aab'，否则构造 'ab'
        while A > 0 or B > 0:
            if A > 0:
                res += a
                A -= 1
            if A > B:
                res += a
                A -= 1
            if B > 0:
                res += b
                B -= 1
        return res