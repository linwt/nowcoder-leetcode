# 最坏情况下需要添加次数等于字符串长度，利用栈存放左括号，当遇到右括号时栈中有左括号配对，则弹出一个左括号并且减少两次添加
class Solution(object):
    def minAddToMakeValid(self, S):
        res = len(S)
        stack = []
        for s in S:
            if s == '(':
                stack.append(s)
            if s == ')' and stack:
                stack.pop()
                res -= 2
        return res