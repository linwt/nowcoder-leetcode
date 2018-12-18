class Solution(object):
    def generateParenthesis(self, n):
        self.res = []
        self.generate('', 0, 0, n)
        return self.res

    def generate(self, s, left, right, n):
        # 左右括号用完时，添加该括号字符串
        if left == n and right == n:
            self.res.append(s)
        # 左括号未完时，添加左括号，再递归
        if left < n:
            self.generate(s+'(', left+1, right, n)
        # 右括号少于左括号时，可添加右括号，再递归
        if right < left:
            self.generate(s+')', left, right+1, n)