class Solution(object):
    def generateParenthesis(self, n):
        # 全局数组，存放所有结果
        self.res = []
        # 调用递归函数，设置初值
        self.generate('', 0, 0, n)
        return self.res

    # 参数：输出字符串，左括号个数，右括号个数，括号限制个数
    def generate(self, s, left, right, n):
        # 终止条件。满足当前条件时，则以下两个条件都不满足，故无需返回，自动终止递归
        if left == n and right == n:
            self.res.append(s)
        # 剪枝条件。输出字符串和左右括号个数动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
        if left < n:
            self.generate(s+'(', left+1, right, n)
        if right < left:
            self.generate(s+')', left, right+1, n)