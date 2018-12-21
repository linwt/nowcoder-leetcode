# 栈的先进先出，不是'#'就进栈，遇到'#'就出栈
class Solution(object):
    def backspaceCompare(self, S, T):
        res1, res2 = [], []
        for s in S:
            if s == '#' and res1:
                res1.pop()
            elif s != '#':
                res1.append(s)
        for t in T:
            if t == '#' and res2:
                res2.pop()
            elif t != '#':
                res2.append(t)
        return ''.join(res1) == ''.join(res2)