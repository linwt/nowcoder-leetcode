# 递归
class Solution(object):
    def letterCombinations(self, digits):
        d = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}

        def combine(s, digits):
            # 终止条件，数字为空时把字符串添加到数组中
            if not digits:
                res.append(s)
            else:
                for char in d[digits[0]]:
                    combine(s+char, digits[1:])

        res = []
        if not digits:
            return res
        combine('', digits)
        return res