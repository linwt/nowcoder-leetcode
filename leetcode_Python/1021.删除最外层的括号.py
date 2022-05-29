# 遍历记录左括号和右括号的个数，若相等则凑成一组
class Solution(object):
    def removeOuterParentheses(self, S):
        l = r = 0
        res = cur = ''
        for s in S:
            if s == '(':
                l += 1
            if s == ')':
                r += 1
            cur += s
            if l == r:
                res += cur[1:-1]
                cur = ''
        return res